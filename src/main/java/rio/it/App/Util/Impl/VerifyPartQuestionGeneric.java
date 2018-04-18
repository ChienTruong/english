package rio.it.App.Util.Impl;

import rio.it.App.Dto.PartQuestionDto;
import rio.it.App.Util.VerifyPartQuestion;

/**
 * Created by chien on 18/04/2018.
 */
public abstract class VerifyPartQuestionGeneric implements VerifyPartQuestion {

    protected FunctionVerify functionVerify;
    protected final String suffixMp3 = "mp3";
    protected final String suffixJpg = "jpg";
    protected final String suffixPng = "png";
    protected final int maxSizeOfQuestionList;
    protected final int maxSizeOfSubQuestionList;
    protected final int maxSizeOfSentenceList;


    public VerifyPartQuestionGeneric(int maxSizeOfQuestionList, int maxSizeOfSubQuestionList, int maxSizeOfSentenceList) {
        this.maxSizeOfQuestionList = maxSizeOfQuestionList;
        this.maxSizeOfSubQuestionList = maxSizeOfSubQuestionList;
        this.maxSizeOfSentenceList = maxSizeOfSentenceList;
    }

    @Override
    public boolean verify(PartQuestionDto partQuestionDto) {
        this.init();
        return doVerify(partQuestionDto);
    }

    private synchronized void init() {
        if (functionVerify == null) {
            functionVerify = new FunctionVerify();
        }
    }

    protected abstract boolean doVerify(PartQuestionDto partQuestionDto);
}
