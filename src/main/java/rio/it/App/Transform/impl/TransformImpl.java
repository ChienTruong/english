package rio.it.App.Transform.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rio.it.App.Dto.PartQuestionDto;
import rio.it.App.Entity.PartQuestionEntity;
import rio.it.App.Transform.*;

/**
 * Created by chien on 15/04/2018.
 */
@Component
public class TransformImpl implements Transform {

    private PartQuestionTransform partQuestionTransform;
    private QuestionTransform questionTransform;
    private SubQuestionTransform subQuestionTransform;
    private ParagraphTransform paragraphTransform;
    private SentenceTransformImpl sentenceTransform;

    @Autowired
    public TransformImpl(PartQuestionTransform partQuestionTransform, QuestionTransform questionTransform, SubQuestionTransform subQuestionTransform, ParagraphTransform paragraphTransform, SentenceTransformImpl sentenceTransform) {
        this.partQuestionTransform = partQuestionTransform;
        this.questionTransform = questionTransform;
        this.subQuestionTransform = subQuestionTransform;
        this.paragraphTransform = paragraphTransform;
        this.sentenceTransform = sentenceTransform;
    }

    @Override
    public PartQuestionEntity doTransformForPartQuestion(PartQuestionDto partQuestionDto) {
        return null;
    }
}
