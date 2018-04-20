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
        this.maxSizeOfSubQuestionList = minSizeOfSubQuestionList;
        this.minSizeOfSubQuestionList = minSizeOfSubQuestionList;
        this.sizeOfSentenceList = sizeOfSentenceList;
    }

    public VerifyPartQuestionGeneric(int maxSizeOfQuestionList, int maxSizeOfSubQuestionList, int minSizeOfSubQuestionList, int sizeOfSentenceList, int sizeOfFileImageList) {
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
                    return this.verifyForQuestionDtoList(partQuestionDto.getQuestionDtoList());
                }
            }
        }
        return false;
    }

    private boolean verifyForQuestionDtoList(List<QuestionDto> questionDtoList) {
        if (this.functionVerify.verifyListNotNullAndNotEmpty(questionDtoList)
                && questionDtoList.size() <= this.maxSizeOfQuestionList) {
            for (QuestionDto questionDto : questionDtoList) {
                if (questionDto == null
                        || !this.verifyForQuestionDto(questionDto)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    protected boolean verifyForParagraphDtoList(List<ParagraphDto> paragraphDtoList) {
        if (paragraphDtoList.size() > 5) {
            return false;
        }
        return this.functionVerify.verifyStringNotNullAndNoEmpty(paragraphDtoList.get(0).getParagraph());
    }

    protected boolean verifyForFileImageDtoList(List<FileImageDto> fileImageDtoList) {
        if (fileImageDtoList.size() <= sizeOfFileImageList) {
            for (FileImageDto fileImageDto : fileImageDtoList) {
                if (fileImageDto == null
                        || !this.functionVerify.verifySuffixOfFile(fileImageDto.getPathFileImage(), this.suffixJpg, this.suffixPng)
                        || this.functionVerify.verifyFileNull(fileImageDto.getPathFileImage())
                        || !this.functionVerify.verifySizeOfFile(fileImageDto.getPathFileImage())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    protected boolean verifyForSubQuestionDtoList(List<SubQuestionDto> subQuestionDtoList) {
        if (subQuestionDtoList.size() <= this.maxSizeOfSubQuestionList
                && subQuestionDtoList.size() >= this.minSizeOfSubQuestionList) {
            for (SubQuestionDto subQuestionDto : subQuestionDtoList) {
                if (subQuestionDto == null
                        || !this.verifyForSubQuestionDto(subQuestionDto)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    protected boolean verifyForSentenceDtoList(List<SentenceDto> sentenceDtoList) {
        if (this.functionVerify.verifyListNotNullAndNotEmpty(sentenceDtoList)
                && sentenceDtoList.size() == this.sizeOfSentenceList) {
            for (SentenceDto sentenceDto : sentenceDtoList) {
                if (sentenceDto == null
                        || !this.verifyForSentenceDto(sentenceDto)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private synchronized void init() {
        if (functionVerify == null) {
            functionVerify = new FunctionVerify();
        }
    }

    protected boolean verifyAllowNullFileMp3(MultipartFile multipartFile) {
        if (this.functionVerify.verifyFileNull(multipartFile)) {
            return true;
        }
        return false;
    }

    protected boolean verifyNotAllowNullFileMp3(MultipartFile multipartFile) {
        if (!this.functionVerify.verifyFileNull(multipartFile)) {
            if (this.functionVerify.verifySuffixOfFile(multipartFile, this.suffixMp3)
                    && this.functionVerify.verifySizeOfFile(multipartFile)) {
                return true;
            }
        }
        return false;
    }

    protected boolean verifyForSentenceDto(SentenceDto sentenceDto) {
        if (functionVerify.verifyStringNotNullAndNoEmpty(sentenceDto.getSentenceEn())) {
            return true;
        }
        return false;
    }

    protected abstract void doLog();

    protected abstract boolean verifyForFileMp3(MultipartFile multipartFile);

    protected boolean verifyForQuestionDto(QuestionDto questionDto) {
        List<ParagraphDto> paragraphDtoList = questionDto.getParagraphDtoList();
        List<FileImageDto> fileImageDtoList = questionDto.getFileImageDtoList();
        List<SubQuestionDto> subQuestionDtoList = questionDto.getSubQuestionDtoList();
        if (this.functionVerify.verifyListNotNullAndNotEmpty(paragraphDtoList)
                && !this.functionVerify.verifyListNotNullAndNotEmpty(fileImageDtoList)
                && this.functionVerify.verifyListNotNullAndNotEmpty(subQuestionDtoList)) {
            if (this.verifyForParagraphDtoList(paragraphDtoList)) {
                if (this.verifyForSubQuestionDtoList(subQuestionDtoList)) {
                    return true;
                }
            }
        }
        return false;
    }

    protected boolean verifyForSubQuestionDto(SubQuestionDto subQuestionDto) {
        if (subQuestionDto.getAnswer() != null
                && this.functionVerify.verifyStringNotNullAndNoEmpty(subQuestionDto.getAnswer().toString())) {
            if (this.functionVerify.verifyStringNotNullAndNoEmpty(subQuestionDto.getSentenceAsk())) {
                return this.verifyForSentenceDtoList(subQuestionDto.getSentenceDtoList());
            }
        }
        return false;
    }
}
