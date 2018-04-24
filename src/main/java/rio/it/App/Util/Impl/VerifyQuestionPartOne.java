package rio.it.App.Util.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import rio.it.App.Model.SentenceModel;
import rio.it.App.Model.SubQuestionModel;
import rio.it.App.Util.VerifyPartQuestion;

import java.util.List;


/**
 * Created by chien on 12/04/2018.
 */
public class VerifyQuestionPartOne extends VerifyPartQuestionGeneric implements VerifyPartQuestion {

    private static final Logger LOGGER = LoggerFactory.getLogger(VerifyQuestionPartOne.class);

    public VerifyQuestionPartOne(boolean allowNullListParagraphModel, boolean allowNullListFileImageModel, int maxSizeOfQuestionList, int maxSizeOfSubQuestionList, int minSizeOfSubQuestionList, int sizeOfSentenceList, int sizeOfFileImageList) {
        super(allowNullListParagraphModel, allowNullListFileImageModel, maxSizeOfQuestionList, maxSizeOfSubQuestionList, minSizeOfSubQuestionList, sizeOfSentenceList, sizeOfFileImageList);
    }

    @Override
    protected void doLog() {
    }

    @Override
    protected boolean verifyForFileMp3(MultipartFile multipartFile) {
        return this.verifyNotAllowNullFileMp3(multipartFile);
    }

    @Override
    protected boolean verifyForSubQuestionModel(SubQuestionModel subQuestionModel) {
        if (subQuestionModel != null
                && subQuestionModel.getAnswer() != null
                && this.functionVerify.verifyStringNotNullAndNoEmpty(subQuestionModel.getAnswer().toString())
                && !this.functionVerify.verifyStringNotNullAndNoEmpty(subQuestionModel.getSentenceAsk())) {
            List<SentenceModel> sentenceModelList = subQuestionModel.getSentenceModelList();
            if (this.functionVerify.verifyListNotNullAndNotEmpty(sentenceModelList)) {
                if (sentenceModelList.size() != this.sizeOfListSentenceModel) {
                    return false;
                }
                return this.filterEachInSentenceModelList(sentenceModelList);
            } else {
                return true;
            }
        }
        return false;
    }
}
