package rio.it.App.Util.Impl;

import org.springframework.web.multipart.MultipartFile;
import rio.it.App.Model.ParagraphModel;
import rio.it.App.Model.QuestionModel;
import rio.it.App.Model.SubQuestionModel;
import rio.it.App.Util.VerifyPartQuestion;

import java.util.List;


/**
 * Created by CongN on 12/04/2018.
 */
public class VerifyQuestionPartThree extends VerifyPartQuestionGeneric implements VerifyPartQuestion {

    public VerifyQuestionPartThree(int maxSizeOfQuestionList, int minSizeOfSubQuestionList, int sizeOfSentenceList) {
        super(maxSizeOfQuestionList, minSizeOfSubQuestionList, sizeOfSentenceList);
    }

    @Override
    protected void doLog() {

    }

    @Override
    protected boolean verifyForFileMp3(MultipartFile multipartFile) {
        return this.verifyNotAllowNullFileMp3(multipartFile);
    }

    @Override
    protected boolean verifyForQuestionModel(QuestionModel questionModel) {
        List<ParagraphModel> paragraphModelList = questionModel.getParagraphModelList();
        List<SubQuestionModel> subQuestionModelList = questionModel.getSubQuestionModelList();
        if (!this.functionVerify.verifyListNotNullAndNotEmpty(questionModel.getFileImageModelList())
                && this.functionVerify.verifyListNotNullAndNotEmpty(subQuestionModelList)) {
            if (this.functionVerify.verifyListNotNullAndNotEmpty(paragraphModelList)) {
                if (!this.verifyForParagraphModel(paragraphModelList.get(0))) {
                    return false;
                }
            }
            if (this.verifyForSubQuestionModelList(subQuestionModelList)) {
                return this.filterEachInSubQuestionModelList(subQuestionModelList);
            }
        }
        return false;
    }
}
