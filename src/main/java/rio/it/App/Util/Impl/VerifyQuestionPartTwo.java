package rio.it.App.Util.Impl;

import rio.it.App.Dto.PartQuestionDto;
import rio.it.App.Util.VerifyPartQuestion;

/**
 * Created by chien on 12/04/2018.
 */
public class VerifyQuestionPartTwo implements VerifyPartQuestion {

    @Override
    public boolean verify(PartQuestionDto partQuestionDto) {
        System.out.println("two");
        return false;
    }
}
