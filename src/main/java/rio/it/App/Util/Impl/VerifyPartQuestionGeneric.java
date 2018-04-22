package rio.it.App.Util.Impl;

import org.springframework.web.multipart.MultipartFile;
import rio.it.App.Dto.*;
import rio.it.App.Util.VerifyPartQuestion;

import java.util.List;

/**
 * Created by chien on 18/04/2018.
 */
public abstract class VerifyPartQuestionGeneric implements VerifyPartQuestion {

    protected FunctionVerify functionVerify;

    protected boolean allowNullListParagraphDto;
    protected boolean allowNullListFileImageDto;

    protected int maxSizeOfQuestionList;
    protected int maxSizeOfSubQuestionList;
    protected int minSizeOfSubQuestionList;
    protected int sizeOfSentenceList;
    protected int sizeOfFileImageList;

    protected final String suffixMp3 = "mp3";
    protected final String suffixJpg = "jpg";
    protected final String suffixPng = "png";

    public VerifyPartQuestionGeneric(int maxSizeOfQuestionList, int minSizeOfSubQuestionList, int sizeOfSentenceList) {
        this.maxSizeOfQuestionList = maxSizeOfQuestionList;
        this.minSizeOfSubQuestionList = minSizeOfSubQuestionList;
        this.maxSizeOfSubQuestionList = minSizeOfSubQuestionList;
        this.sizeOfSentenceList = sizeOfSentenceList;
    }

    public VerifyPartQuestionGeneric(boolean allowNullListParagraphDto, boolean allowNullListFileImageDto, int maxSizeOfQuestionList, int minSizeOfSubQuestionList, int sizeOfSentenceList) {
        this.allowNullListParagraphDto = allowNullListParagraphDto;
        this.allowNullListFileImageDto = allowNullListFileImageDto;
        this.maxSizeOfQuestionList = maxSizeOfQuestionList;
        this.maxSizeOfSubQuestionList = minSizeOfSubQuestionList;
        this.minSizeOfSubQuestionList = minSizeOfSubQuestionList;
        this.sizeOfSentenceList = sizeOfSentenceList;
    }

    public VerifyPartQuestionGeneric(boolean allowNullListParagraphDto, boolean allowNullListFileImageDto, int maxSizeOfQuestionList, int maxSizeOfSubQuestionList, int minSizeOfSubQuestionList, int sizeOfSentenceList, int sizeOfFileImageList) {
        this.allowNullListParagraphDto = allowNullListParagraphDto;
        this.allowNullListFileImageDto = allowNullListFileImageDto;
        this.maxSizeOfQuestionList = maxSizeOfQuestionList;
        this.maxSizeOfSubQuestionList = maxSizeOfSubQuestionList;
        this.minSizeOfSubQuestionList = minSizeOfSubQuestionList;
        this.sizeOfSentenceList = sizeOfSentenceList;
        this.sizeOfFileImageList = sizeOfFileImageList;
    }

    @Override
    public boolean verify(PartQuestionDto partQuestionDto) {
        this.init();
        this.doLog();
        if (partQuestionDto != null) {
            if (functionVerify.verifyStringNotNullAndNoEmpty(partQuestionDto.getNamePart())) {
                if (this.verifyForFileMp3(partQuestionDto.getPathFileMp3())) {
                    List<QuestionDto> questionDtoList = partQuestionDto.getQuestionDtoList();
                    if (this.verifyForQuestionDtoList(questionDtoList)) {
                        return filterEachInQuestionDtoList(questionDtoList);
                    }
                }
            }
        }
        return false;
    }

    /**
     * @param questionDtoList
     * @return
     */
    protected boolean verifyForQuestionDtoList(List<QuestionDto> questionDtoList) {
        if (this.functionVerify.verifyListNotNullAndNotEmpty(questionDtoList)
                && questionDtoList.size() <= this.maxSizeOfQuestionList) {
            return true;
        }
        return false;
    }

    /**
     * @param questionDtoList
     * @return
     */
    protected boolean filterEachInQuestionDtoList(List<QuestionDto> questionDtoList) {
        for (QuestionDto questionDto : questionDtoList) {
            if (questionDto == null
                    || !this.verifyForQuestionDto(questionDto)) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param questionDto
     * @return
     */
    protected boolean verifyForQuestionDto(QuestionDto questionDto) {
        List<ParagraphDto> paragraphDtoList = questionDto.getParagraphDtoList();
        List<FileImageDto> fileImageDtoList = questionDto.getFileImageDtoList();
        List<SubQuestionDto> subQuestionDtoList = questionDto.getSubQuestionDtoList();
        if (this.functionVerify.verifyListNotNullAndNotEmpty(paragraphDtoList) != this.allowNullListParagraphDto
                && this.functionVerify.verifyListNotNullAndNotEmpty(fileImageDtoList) != this.allowNullListFileImageDto
                && this.functionVerify.verifyListNotNullAndNotEmpty(subQuestionDtoList)) {
            if (!this.allowNullListParagraphDto
                    && !this.verifyForParagraphDtoList(paragraphDtoList)) {
                return false;
            }
            if (!this.allowNullListFileImageDto
                    && !this.verifyForFileImageDtoList(fileImageDtoList)) {
                return false;
            }
            if (this.verifyForSubQuestionDtoList(subQuestionDtoList)) {
                return filterEachInSubQuestionDtoList(subQuestionDtoList);
            }
        }
        return false;
    }

    /**
     * @param paragraphDtoList
     * @return
     * @note not edit
     */
    protected boolean verifyForParagraphDtoList(List<ParagraphDto> paragraphDtoList) {
        if (paragraphDtoList.size() > 4) {
            return false;
        }
        return this.verifyForParagraphDto(paragraphDtoList.get(0));
    }

    /**
     * @param paragraphDto
     * @return
     */
    protected boolean verifyForParagraphDto(ParagraphDto paragraphDto) {
        if (paragraphDto != null) {
            String paragraph = paragraphDto.getParagraph();
            if (paragraph != null
                    && this.functionVerify.verifyStringNotNullAndNoEmpty(paragraph)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param fileImageDtoList
     * @return
     * @note not edit
     */
    protected boolean verifyForFileImageDtoList(List<FileImageDto> fileImageDtoList) {
        if (fileImageDtoList.size() <= sizeOfFileImageList) {
            for (FileImageDto fileImageDto : fileImageDtoList) {
                if (!this.verifyForFileImageDto(fileImageDto)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * @param fileImageDto
     * @return
     */
    protected boolean verifyForFileImageDto(FileImageDto fileImageDto) {
        if (fileImageDto != null
                && this.functionVerify.verifySuffixOfFile(fileImageDto.getPathFileImage(), this.suffixJpg, this.suffixPng)
                && !this.functionVerify.verifyFileNull(fileImageDto.getPathFileImage())
                && this.functionVerify.verifySizeOfFile(fileImageDto.getPathFileImage())) {
            return true;
        }
        return false;
    }

    /**
     * @param subQuestionDtoList
     * @return
     */
    protected boolean verifyForSubQuestionDtoList(List<SubQuestionDto> subQuestionDtoList) {
        if (subQuestionDtoList.size() <= this.maxSizeOfSubQuestionList
                && subQuestionDtoList.size() >= this.minSizeOfSubQuestionList) {
            return true;
        }
        return false;
    }

    /**
     *
     */
    protected boolean filterEachInSubQuestionDtoList(List<SubQuestionDto> subQuestionDtoList) {
        for (SubQuestionDto subQuestionDto : subQuestionDtoList) {
            if (!this.verifyForSubQuestionDto(subQuestionDto)) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param subQuestionDto
     * @return
     */
    protected boolean verifyForSubQuestionDto(SubQuestionDto subQuestionDto) {
        if (subQuestionDto != null
                && subQuestionDto.getAnswer() != null
                && this.functionVerify.verifyStringNotNullAndNoEmpty(subQuestionDto.getAnswer().toString())
                && this.functionVerify.verifyStringNotNullAndNoEmpty(subQuestionDto.getSentenceAsk())) {
            List<SentenceDto> sentenceDtoList = subQuestionDto.getSentenceDtoList();
            if (this.verifyForSentenceDtoList(sentenceDtoList)) {
                return filterEachInSentenceDtoList(sentenceDtoList);
            }
        }
        return false;
    }

    /**
     * @param sentenceDtoList
     * @return
     */
    protected boolean verifyForSentenceDtoList(List<SentenceDto> sentenceDtoList) {
        if (this.functionVerify.verifyListNotNullAndNotEmpty(sentenceDtoList)
                && sentenceDtoList.size() == this.sizeOfSentenceList) {
            return true;
        }
        return false;
    }

    /**
     * @param sentenceDtoList
     * @return
     */
    protected boolean filterEachInSentenceDtoList(List<SentenceDto> sentenceDtoList) {
        for (SentenceDto sentenceDto : sentenceDtoList) {
            if (sentenceDto == null
                    || !this.verifyForSentenceDto(sentenceDto)) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param sentenceDto
     * @return
     */
    protected boolean verifyForSentenceDto(SentenceDto sentenceDto) {
        if (functionVerify.verifyStringNotNullAndNoEmpty(sentenceDto.getSentenceEn())) {
            return true;
        }
        return false;
    }

    //

    /**
     *
     */
    protected abstract void doLog();

    /**
     * @param multipartFile
     * @return
     */
    protected abstract boolean verifyForFileMp3(MultipartFile multipartFile);

    // create by Son
    // not allow edit code below and this comment
    // when you want edit below code, u must ask member of your team
    // fuck off when u do this not ask team

    /**
     *
     */
    private synchronized void init() {
        if (functionVerify == null) {
            functionVerify = new FunctionVerify();
        }
    }

    /**
     * @param multipartFile
     * @return
     */
    protected boolean verifyAllowNullFileMp3(MultipartFile multipartFile) {
        if (this.functionVerify.verifyFileNull(multipartFile)) {
            return true;
        }
        return false;
    }

    /**
     * @param multipartFile
     * @return
     */
    protected boolean verifyNotAllowNullFileMp3(MultipartFile multipartFile) {
        if (!this.functionVerify.verifyFileNull(multipartFile)) {
            if (this.functionVerify.verifySuffixOfFile(multipartFile, this.suffixMp3)
                    && this.functionVerify.verifySizeOfFile(multipartFile)) {
                return true;
            }
        }
        return false;
    }
}
