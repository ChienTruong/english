package rio.it.App.Util.Impl;

import org.springframework.web.multipart.MultipartFile;
import rio.it.App.Model.*;
import rio.it.App.Util.VerifyPartQuestion;

import java.util.List;

/**
 * Created by chien on 18/04/2018.
 */
public abstract class VerifyPartQuestionGeneric implements VerifyPartQuestion {

    protected FunctionVerify functionVerify;

    protected boolean allowNullListParagraphModel;
    protected boolean allowNullListFileImageModel;

    protected int maxSizeOfListQuestionModel;
    protected int maxSizeOfListSubQuestionModel;
    protected int minSizeOfListSubQuestionModel;
    protected int sizeOfListSentenceModel;
    protected int sizeOfListFileImageModel;

    protected final String suffixMp3 = "mp3";
    protected final String suffixJpg = "jpg";
    protected final String suffixPng = "png";

    public VerifyPartQuestionGeneric(int maxSizeOfListQuestionModel, int minSizeOfListSubQuestionModel, int sizeOfListSentenceModel) {
        this.maxSizeOfListQuestionModel = maxSizeOfListQuestionModel;
        this.minSizeOfListSubQuestionModel = minSizeOfListSubQuestionModel;
        this.maxSizeOfListSubQuestionModel = minSizeOfListSubQuestionModel;
        this.sizeOfListSentenceModel = sizeOfListSentenceModel;
    }

    public VerifyPartQuestionGeneric(boolean allowNullListParagraphModel, boolean allowNullListFileImageModel, int maxSizeOfListQuestionModel, int minSizeOfListSubQuestionModel, int sizeOfListSentenceModel) {
        this.allowNullListParagraphModel = allowNullListParagraphModel;
        this.allowNullListFileImageModel = allowNullListFileImageModel;
        this.maxSizeOfListQuestionModel = maxSizeOfListQuestionModel;
        this.maxSizeOfListSubQuestionModel = minSizeOfListSubQuestionModel;
        this.minSizeOfListSubQuestionModel = minSizeOfListSubQuestionModel;
        this.sizeOfListSentenceModel = sizeOfListSentenceModel;
    }

    public VerifyPartQuestionGeneric(boolean allowNullListParagraphModel, boolean allowNullListFileImageModel, int maxSizeOfListQuestionModel, int maxSizeOfListSubQuestionModel, int minSizeOfListSubQuestionModel, int sizeOfListSentenceModel, int sizeOfListFileImageModel) {
        this.allowNullListParagraphModel = allowNullListParagraphModel;
        this.allowNullListFileImageModel = allowNullListFileImageModel;
        this.maxSizeOfListQuestionModel = maxSizeOfListQuestionModel;
        this.maxSizeOfListSubQuestionModel = maxSizeOfListSubQuestionModel;
        this.minSizeOfListSubQuestionModel = minSizeOfListSubQuestionModel;
        this.sizeOfListSentenceModel = sizeOfListSentenceModel;
        this.sizeOfListFileImageModel = sizeOfListFileImageModel;
    }

    @Override
    public boolean verify(final PartQuestionModel partQuestionModel) {
        this.init();
        this.doLog();
        if (partQuestionModel != null) {
            if (functionVerify.verifyStringNotNullAndNoEmpty(partQuestionModel.getNamePart())) {
                if (this.verifyForFileMp3(partQuestionModel.getPathFileMp3())) {
                    List<QuestionModel> questionModelList = partQuestionModel.getQuestionModelList();
                    if (this.verifyForQuestionModelList(questionModelList)) {
                        return filterEachInQuestionModelList(questionModelList);
                    }
                }
            }
        }
        return false;
    }

    /**
     * @param questionModelList
     * @return
     */
    protected boolean verifyForQuestionModelList(List<QuestionModel> questionModelList) {
        if (this.functionVerify.verifyListNotNullAndNotEmpty(questionModelList)
                && questionModelList.size() <= this.maxSizeOfListQuestionModel) {
            return true;
        }
        return false;
    }

    /**
     * @param questionModelList
     * @return
     */
    protected boolean filterEachInQuestionModelList(List<QuestionModel> questionModelList) {
        for (QuestionModel questionModel : questionModelList) {
            if (questionModel == null
                    || !this.verifyForQuestionModel(questionModel)) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param questionModel
     * @return
     */
    protected boolean verifyForQuestionModel(QuestionModel questionModel) {
        List<ParagraphModel> paragraphModelList = questionModel.getParagraphModelList();
        List<FileImageModel> fileImageModelList = questionModel.getFileImageModelList();
        List<SubQuestionModel> subQuestionModelList = questionModel.getSubQuestionModelList();
        if (this.functionVerify.verifyListNotNullAndNotEmpty(paragraphModelList) != this.allowNullListParagraphModel
                && this.functionVerify.verifyListNotNullAndNotEmpty(fileImageModelList) != this.allowNullListFileImageModel
                && this.functionVerify.verifyListNotNullAndNotEmpty(subQuestionModelList)) {
            if (!this.allowNullListParagraphModel
                    && !this.verifyForParagraphModelList(paragraphModelList)) {
                return false;
            }
            if (!this.allowNullListFileImageModel
                    && !this.verifyForFileImageModelList(fileImageModelList)) {
                return false;
            }
            if (this.verifyForSubQuestionModelList(subQuestionModelList)) {
                return filterEachInSubQuestionModelList(subQuestionModelList);
            }
        }
        return false;
    }

    /**
     * @param paragraphModelList
     * @return
     * @note not edit
     */
    protected boolean verifyForParagraphModelList(List<ParagraphModel> paragraphModelList) {
        if (paragraphModelList.size() > 4) {
            return false;
        }
        return this.verifyForParagraphModel(paragraphModelList.get(0));
    }

    /**
     * @param paragraphModel
     * @return
     */
    protected boolean verifyForParagraphModel(ParagraphModel paragraphModel) {
        if (paragraphModel != null) {
            String paragraph = paragraphModel.getParagraph();
            if (paragraph != null
                    && this.functionVerify.verifyStringNotNullAndNoEmpty(paragraph)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param fileImageModelList
     * @return
     * @note not edit
     */
    protected boolean verifyForFileImageModelList(List<FileImageModel> fileImageModelList) {
        if (fileImageModelList.size() <= sizeOfListFileImageModel) {
            for (FileImageModel fileImageModel : fileImageModelList) {
                if (!this.verifyForFileImageModel(fileImageModel)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * @param fileImageModel
     * @return
     */
    protected boolean verifyForFileImageModel(FileImageModel fileImageModel) {
        if (fileImageModel != null
                && this.functionVerify.verifySuffixOfFile(fileImageModel.getPathFileImage(), this.suffixJpg, this.suffixPng)
                && !this.functionVerify.verifyFileNull(fileImageModel.getPathFileImage())
                && this.functionVerify.verifySizeOfFile(fileImageModel.getPathFileImage())) {
            return true;
        }
        return false;
    }

    /**
     * @param subQuestionModelList
     * @return
     */
    protected boolean verifyForSubQuestionModelList(List<SubQuestionModel> subQuestionModelList) {
        if (subQuestionModelList.size() <= this.maxSizeOfListSubQuestionModel
                && subQuestionModelList.size() >= this.minSizeOfListSubQuestionModel) {
            return true;
        }
        return false;
    }

    /**
     *
     */
    protected boolean filterEachInSubQuestionModelList(List<SubQuestionModel> subQuestionModelList) {
        for (SubQuestionModel subQuestionModel : subQuestionModelList) {
            if (!this.verifyForSubQuestionModel(subQuestionModel)) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param subQuestionModel
     * @return
     */
    protected boolean verifyForSubQuestionModel(SubQuestionModel subQuestionModel) {
        if (subQuestionModel != null
                && subQuestionModel.getAnswer() != null
                && this.functionVerify.verifyStringNotNullAndNoEmpty(subQuestionModel.getAnswer().toString())
                && this.functionVerify.verifyStringNotNullAndNoEmpty(subQuestionModel.getSentenceAsk())) {
            List<SentenceModel> sentenceModelList = subQuestionModel.getSentenceModelList();
            if (this.verifyForSentenceModelList(sentenceModelList)) {
                return filterEachInSentenceModelList(sentenceModelList);
            }
        }
        return false;
    }

    /**
     * @param sentenceModelList
     * @return
     */
    protected boolean verifyForSentenceModelList(List<SentenceModel> sentenceModelList) {
        if (this.functionVerify.verifyListNotNullAndNotEmpty(sentenceModelList)
                && sentenceModelList.size() == this.sizeOfListSentenceModel) {
            return true;
        }
        return false;
    }

    /**
     * @param sentenceModelList
     * @return
     */
    protected boolean filterEachInSentenceModelList(List<SentenceModel> sentenceModelList) {
        for (SentenceModel sentenceModel : sentenceModelList) {
            if (sentenceModel == null
                    || !this.verifyForSentenceModel(sentenceModel)) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param sentenceModel
     * @return
     */
    protected boolean verifyForSentenceModel(SentenceModel sentenceModel) {
        if (functionVerify.verifyStringNotNullAndNoEmpty(sentenceModel.getSentenceEn())) {
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
