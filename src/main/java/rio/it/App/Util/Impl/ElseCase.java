//package rio.it.App.Util.Impl;
//
//import org.springframework.stereotype.Component;
//import rio.it.App.Util.FactoryVerifyPartQuestion;
//import rio.it.App.Util.Part;
//import rio.it.App.Util.VerifyPartQuestion;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * Created by chien on 12/04/2018.
// */
//@Component
//public class FactoryVerifyPartQuestionImpl implements FactoryVerifyPartQuestion {
//
//    /**
//     *
//     */
//    private Map<Part, VerifyPartQuestion> mapPartVerifyPartQuestion;
//
//    /**
//     *
//     */
//    private static final Map<Part, Class<? extends VerifyPartQuestion>> mapReflectionBetweenPartAndClassVerify;
//
//    /**
//     *
//     */
//    static {
//        mapReflectionBetweenPartAndClassVerify = new HashMap<>(7);
//        mapReflectionBetweenPartAndClassVerify.put(Part.ONE, VerifyQuestionPartOne.class);
//        mapReflectionBetweenPartAndClassVerify.put(Part.TWO, VerifyQuestionPartTwo.class);
//        mapReflectionBetweenPartAndClassVerify.put(Part.THREE, VerifyQuestionPartThree.class);
//        mapReflectionBetweenPartAndClassVerify.put(Part.FOUR, VerifyQuestionPartFour.class);
//        mapReflectionBetweenPartAndClassVerify.put(Part.FIVE, VerifyQuestionPartFive.class);
//        mapReflectionBetweenPartAndClassVerify.put(Part.SIX, VerifyQuestionPartSix.class);
//        mapReflectionBetweenPartAndClassVerify.put(Part.SEVEN, VerifyQuestionPartSeven.class);
//    }
//
//    /**
//     *
//     * @param part
//     * @return
//     * @throws IllegalAccessException
//     * @throws InstantiationException
//     */
//    @Override
//    public VerifyPartQuestion getVerify(Part part) throws IllegalAccessException, InstantiationException {
//        init();
//        if (!this.mapPartVerifyPartQuestion.containsKey(part)) {
//            this.mapPartVerifyPartQuestion.put(part, this.mapReflectionBetweenPartAndClassVerify.get(part).newInstance());
//        }
//        return this.mapPartVerifyPartQuestion.get(part);
//    }
//
//    /**
//     *
//     */
//    private void init() {
//        if (this.mapPartVerifyPartQuestion == null) {
//            this.mapPartVerifyPartQuestion = new HashMap<>(7);
//        }
//    }
//
//}
