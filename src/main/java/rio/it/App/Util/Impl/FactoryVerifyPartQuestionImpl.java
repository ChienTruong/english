package rio.it.App.Util.Impl;

import org.springframework.stereotype.Component;
import rio.it.App.Util.FactoryVerifyPartQuestion;
import rio.it.App.Util.Part;
import rio.it.App.Util.VerifyPartQuestion;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chien on 12/04/2018.
 */
@Component
public class FactoryVerifyPartQuestionImpl implements FactoryVerifyPartQuestion {

    private Map<Part, VerifyPartQuestion> mapVerifyPartQuestion;

    /**
     * @param part
     * @return
     * @Note_11/04/18_Chien: if don't like this solution, u can view more solution else in file ElseCase.java, or think else solution
     * --> choice result:
     */
    @Override
    public VerifyPartQuestion getVerify(@NotNull Part part) {
        init();
        if (!this.mapVerifyPartQuestion.containsKey(part)) {
            VerifyPartQuestion verifyPartQuestion = choice(part);
            this.mapVerifyPartQuestion.put(part, verifyPartQuestion);
        }
        return this.mapVerifyPartQuestion.get(part);
    }

    private VerifyPartQuestion choice(@NotNull Part part) {
        VerifyPartQuestion verifyPartQuestion = null;
        switch (part) {
            case ONE:
                verifyPartQuestion = new VerifyQuestionPartOne();
                break;
            case TWO:
                verifyPartQuestion = new VerifyQuestionPartTwo();
                break;
            case THREE:
                verifyPartQuestion = new VerifyQuestionPartThree();
                break;
            case FOUR:
                verifyPartQuestion = new VerifyQuestionPartFour();
                break;
            case FIVE:
                verifyPartQuestion = new VerifyQuestionPartFive();
                break;
            case SIX:
                verifyPartQuestion = new VerifyQuestionPartSix();
                break;
            case SEVEN:
                verifyPartQuestion = new VerifyQuestionPartSeven();
                break;
        }
        return verifyPartQuestion;
    }

    private void init() {
        if (mapVerifyPartQuestion == null) {
            mapVerifyPartQuestion = new HashMap<>(7);
        }
    }
}
