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

    public VerifyPartQuestionGeneric(int maxSizeOfQuestionList, int maxSizeOfSubQuestionList, int minSizeOfSubQuestionList, int sizeOfSentenceList) {
        this.maxSizeOfQuestionList = maxSizeOfQuestionList;
        this.maxSizeOfSubQuestionList = maxSizeOfSubQuestionList;
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
                    return this.doVerifyForQuestionDtoList(partQuestionDto.getQuestionDtoList());
                }
            }
        }
        return false;
    }

    private boolean doVerifyForQuestionDtoList(List<QuestionDto> questionDtoList) {
        if (this.functionVerify.verifyListNotNullAndNotEmpty(questionDtoList)
                && questionDtoList.size() <= this.maxSizeOfQuestionList) {
            for (QuestionDto questionDto : questionDtoList) {
                if (!this.verifyForQuestionDto(questionDto)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    protected boolean doVerifyForParagraphList(List<ParagraphDto> paragraphDtoList) {
        return this.functionVerify.verifyStringNotNullAndNoEmpty(paragraphDtoList.get(0).getParagraph());
    }

    protected boolean doVerifyForFileImageList(List<FileImageDto> fileImageDtoList) {
        if (fileImageDtoList.size() <= sizeOfFileImageList) {
            for (FileImageDto fileImageDto : fileImageDtoList) {
                if (!this.functionVerify.verifySuffixOfFile(fileImageDto.getPathFileImage(), this.suffixJpg, this.suffixPng)
                        || this.functionVerify.verifyFileNull(fileImageDto.getPathFileImage())
                        || !this.functionVerify.verifySizeOfFile(fileImageDto.getPathFileImage())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    protected boolean doVerifyForSubQuestionList(List<SubQuestionDto> subQuestionDtoList) {
        if (subQuestionDtoList.size() <= this.maxSizeOfSubQuestionList
                && subQuestionDtoList.size() >= this.minSizeOfSubQuestionList) {
            for (SubQuestionDto subQuestionDto : subQuestionDtoList) {
                if (!this.verifyForSubQuestionDto(subQuestionDto)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    protected boolean doVerifyForSentenceList(List<SentenceDto> sentenceDtoList) {
        if (this.functionVerify.verifyListNotNullAndNotEmpty(sentenceDtoList)
                && sentenceDtoList.size() == this.sizeOfSentenceList) {
            for (SentenceDto sentenceDto : sentenceDtoList) {
                if (!this.verifyForSentenceDto(sentenceDto)) {
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

    protected abstract boolean verifyForQuestionDto(QuestionDto questionDto);

    protected abstract boolean verifyForSubQuestionDto(SubQuestionDto subQuestionDto);
}
