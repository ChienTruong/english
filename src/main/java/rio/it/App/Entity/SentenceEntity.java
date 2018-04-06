package rio.it.App.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by chien on 06/04/2018.
 */
@Entity
@Data
public class SentenceEntity {
    @Id
    private Long sentenceId;
    private String character;
    private String sentenceEn;
    private String sentenceVn;
    @ManyToOne()
    @JoinColumn(name = "questionId")
    private SubQuestionEntity subQuestionEntity;
}
