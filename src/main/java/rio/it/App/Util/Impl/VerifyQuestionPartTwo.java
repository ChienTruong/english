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
public class VerifyQuestionPartTwo extends VerifyPartQuestionGeneric implements VerifyPartQuestion {

    private static final Logger LOGGER = LoggerFactory.getLogger(VerifyQuestionPartTwo.class);

    public VerifyQuestionPartTwo(boolean allowNullListParagraphModel, boolean allowNullListFileImageModel, int maxSizeOfQuestionList, int minSizeOfSubQuestionList, int sizeOfSentenceList) {
        super(allowNullListParagraphModel, allowNullListFileImageModel, maxSizeOfQuestionList, minSizeOfSubQuestionList, sizeOfSentenceList);
    }

    @Override
    protected void doLog() {
        LOGGER.info("Do verify for partQuestionModel part two");
    }

    @Override
    protected boolean verifyForFileMp3(MultipartFile multipartFile) {
        return this.verifyNotAllowNullFileMp3(multipartFile);
    }

    @Override
    protected boolean verifyForSubQuestionModel(SubQuestionModel subQuestionModel) {
        if (subQuestionModel != null
                && subQuestionModel.getAnswer() != null
                && this.functionVerify.verifyStringNotNullAndNoEmpty(subQuestionModel.getAnswer().toString())) {
            if (this.functionVerify.verifyStringNotNullAndNoEmpty(subQuestionModel.getSentenceAsk())) {
                List<SentenceModel> sentenceModelList = subQuestionModel.getSentenceModelList();
                if (this.verifyForSentenceModelList(sentenceModelList)) {
                    return this.filterEachInSentenceModelList(sentenceModelList);
                }
            } else {
                return true;
            }
        }
        return false;
    }
}
