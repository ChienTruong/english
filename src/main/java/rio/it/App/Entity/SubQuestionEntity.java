package rio.it.App.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chien on 06/04/2018.
 */
@Entity
@Data
public class SubQuestionEntity {
    @Id
    private Long subQuestionId;
    private String sentenceAsk;
    private String translateAsk;
    private Character answer;
    @OneToMany(mappedBy = "subQuestionEntity")
    private List<SentenceEntity> sentenceEntityList = new ArrayList(4);
    @ManyToOne()
    @JoinColumn(name = "questionEntityId")
    private QuestionEntity questionEntity;
}