package rio.it.App.Util.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rio.it.App.Dto.PartQuestionDto;
import rio.it.App.Dto.QuestionDto;
import rio.it.App.Dto.SubQuestionDto;
import rio.it.App.Util.VerifyPartQuestion;

/**
 * Created by chien on 12/04/2018.
 */
public class VerifyQuestionPartFive extends VerifyPartQuestionGeneric implements VerifyPartQuestion {

    private static final Logger LOGGER = LoggerFactory.getLogger(VerifyQuestionPartFive.class);

    public VerifyQuestionPartFive(int maxSizeOfQuestionList, int maxSizeOfSubQuestionList, int maxSizeOfSentenceList) {
        super(maxSizeOfQuestionList, maxSizeOfSubQuestionList, maxSizeOfSentenceList);
    }

    @Override
    protected void doLog() {
        LOGGER.info("Do verify for partQuestionDto part five");
    }

    @Override
    protected boolean verifyForPartQuestionDto(PartQuestionDto partQuestionDto) {
        return false;
    }

    @Override
    protected boolean verifyForQuestionDto(QuestionDto questionDto) {
        return false;
    }

    @Override
    protected boolean verifyForSubQuestionDto(SubQuestionDto subQuestionDto) {
        return false;
    }
}
