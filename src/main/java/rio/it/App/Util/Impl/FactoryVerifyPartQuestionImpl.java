package rio.it.App.Util.Impl;

import org.springframework.stereotype.Component;
import rio.it.App.Util.FactoryVerifyPartQuestion;
import rio.it.App.Util.PartEnum;
import rio.it.App.Util.VerifyPartQuestion;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chien on 12/04/2018.
 */
@Component
public class FactoryVerifyPartQuestionImpl implements FactoryVerifyPartQuestion {

    private Map<PartEnum, VerifyPartQuestion> mapVerifyPartQuestion;

    /**
     * @param part
     * @return
     * --> choice result: this class
     */
    @Override
    public VerifyPartQuestion getVerify(@NotNull PartEnum part) {
        init();
        if (!this.mapVerifyPartQuestion.containsKey(part)) {
            VerifyPartQuestion verifyPartQuestion = choice(part);
            this.mapVerifyPartQuestion.put(part, verifyPartQuestion);
        }
        return this.mapVerifyPartQuestion.get(part);
    }

    private VerifyPartQuestion choice(@NotNull PartEnum part) {
        VerifyPartQuestion verifyPartQuestion = null;
        switch (part) {
            case ONE:
                verifyPartQuestion = new VerifyQuestionPartOne();
                break;
            case TWO:
                verifyPartQuestion = new VerifyQuestionPartTwo(30, 1, 3);
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
