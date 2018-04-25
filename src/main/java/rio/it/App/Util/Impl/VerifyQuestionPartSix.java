package rio.it.App.Util.Impl;

import rio.it.App.Util.VerifyPartQuestion;

/**
 * Created by chien on 12/04/2018.
 */
public class VerifyQuestionPartSix extends VerifyQuestionPartFive implements VerifyPartQuestion {

    public VerifyQuestionPartSix(boolean allowNullListParagraphModel, boolean allowNullListFileImageModel, int maxSizeOfQuestionList, int minSizeOfSubQuestionList, int sizeOfSentenceList) {
        super(allowNullListParagraphModel, allowNullListFileImageModel, maxSizeOfQuestionList, minSizeOfSubQuestionList, sizeOfSentenceList);
    }

    @Override
    protected void doLog() {

    }
}
