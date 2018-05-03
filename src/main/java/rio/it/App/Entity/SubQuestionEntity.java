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
public class SubQuestionEntity  extends IdEntity {

    private String sentenceAsk;
    private String translateAsk;
    private String answer;
    @OneToMany(mappedBy = "subQuestionEntity",cascade = CascadeType.ALL)
    private List<SentenceEntity> sentenceEntityList;
    @ManyToOne()
    @JoinColumn(name = "questionEntityId")
    private QuestionEntity questionEntity;
}
