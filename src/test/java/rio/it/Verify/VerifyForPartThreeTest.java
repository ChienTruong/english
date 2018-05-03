package rio.it.Verify;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rio.it.App.Model.ParagraphModel;
import rio.it.App.Model.QuestionModel;
import rio.it.App.Model.SentenceModel;
import rio.it.App.Model.SubQuestionModel;
import rio.it.App.Util.Impl.VerifyQuestionPartThree;
import rio.it.App.Util.VerifyPartQuestion;

import java.io.IOException;

/**
 * Created by CongN on 4/21/2018.
 */

public class VerifyForPartThreeTest extends VerifyForListeningTest {

    private int maxSizeOfListQuestionModel = 10;
    private int maxSizeOfListSubQuestionModel = 3;
    private int sizeOfListSentence = 4;

    @Before
    protected void init() throws IOException {
        super.init();
    }

    @Override
    protected VerifyPartQuestion makeVerification() {
        return new VerifyQuestionPartThree(this.maxSizeOfListQuestionModel, this.maxSizeOfListSubQuestionModel, this.sizeOfListSentence);
    }


    @Test
    public void testPartThreeWithDataNotFull_Success(){
        for(int i = 0; i < this.maxSizeOfListQuestionModel; i++){
            QuestionModel questionModel = this.makeDataForInput.makeQuestionModel(true, true);
            for (int j = 0; j < this.maxSizeOfListSubQuestionModel; j++){
                SubQuestionModel subQuestionModel = this.makeDataForInput.makeSubQuestionModel(false,false);
                for (int z= 0 ; z < this.sizeOfListSentence ; z++){
                    SentenceModel sentenceModel = this.makeDataForInput.makeSentenceModel(false);
                    subQuestionModel.getSentenceModelList().add(sentenceModel);
                }
                questionModel.getSubQuestionModelList().add(subQuestionModel);
            }
            this.partQuestionModel.getQuestionModelList().add(questionModel);
        }
        Assert.assertTrue(this.verifyPartQuestion.verify(this.partQuestionModel));
    }


    @Test
    public  void testPartThreeWithDataFull_Success(){
        for(int i = 0; i<this.maxSizeOfListQuestionModel; i++){
            QuestionModel questionModel = this.makeDataForInput.makeQuestionModel(false,true);
            ParagraphModel paragraphModel = this.makeDataForInput.makeParagraphModel(false);
            questionModel.getParagraphModelList().add(paragraphModel);
            for(int j = 0; j<this.maxSizeOfListSubQuestionModel; j++){
                SubQuestionModel subQuestionModel = this.makeDataForInput.makeSubQuestionModel(false,false);
                for (int z = 0; z < this.sizeOfListSentence ; z++){
                    SentenceModel sentenceModel = this.makeDataForInput.makeSentenceModel(false);
                    subQuestionModel.getSentenceModelList().add(sentenceModel);
                }
                questionModel.getSubQuestionModelList().add(subQuestionModel);
            }
            this.partQuestionModel.getQuestionModelList().add(questionModel);
        }
        Assert.assertTrue(this.verifyPartQuestion.verify(this.partQuestionModel));
    }

}
