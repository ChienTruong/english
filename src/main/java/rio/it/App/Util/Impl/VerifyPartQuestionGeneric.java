package rio.it.App.Util.Impl;

import rio.it.App.Dto.PartQuestionDto;
import rio.it.App.Dto.QuestionDto;
import rio.it.App.Dto.SentenceDto;
import rio.it.App.Dto.SubQuestionDto;
import rio.it.App.Util.VerifyPartQuestion;

/**
 * Created by chien on 18/04/2018.
 */
public abstract class VerifyPartQuestionGeneric implements VerifyPartQuestion {

    protected FunctionVerify functionVerify;

    protected int maxSizeOfQuestionList;
    protected int maxSizeOfSubQuestionList;
    protected int maxSizeOfSentenceList;

    protected final String suffixMp3 = "mp3";
    protected final String suffixJpg = "jpg";
    protected final String suffixPng = "png";

    public VerifyPartQuestionGeneric(int maxSizeOfQuestionList, int maxSizeOfSubQuestionList, int maxSizeOfSentenceList) {
        this.maxSizeOfQuestionList = maxSizeOfQuestionList;
        this.maxSizeOfSubQuestionList = maxSizeOfSubQuestionList;
        this.maxSizeOfSentenceList = maxSizeOfSentenceList;
    }

    @Override
    public boolean verify(PartQuestionDto partQuestionDto) {
        this.init();
        this.doLog();
        if (partQuestionDto != null) {
            if (functionVerify.verifyNamePart(partQuestionDto.getNamePart())) {
                return this.verifyForPartQuestionDto(partQuestionDto);
            }
        }
        return false;
    }

    private synchronized void init() {
        if (functionVerify == null) {
            functionVerify = new FunctionVerify();
        }
    }

    protected boolean verifyForSentenceDto(SentenceDto sentenceDto) {
        if (functionVerify.verifyStringNotNullAndNoEmpty(sentenceDto.getSentenceEn())) {
            return true;
        }
        return false;
    }

    protected abstract void doLog();

    protected abstract boolean verifyForPartQuestionDto(PartQuestionDto partQuestionDto);

    protected abstract boolean verifyForQuestionDto(QuestionDto questionDto);

    protected abstract boolean verifyForSubQuestionDto(SubQuestionDto subQuestionDto);
}
