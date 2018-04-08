package rio.it.App.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by chien on 08/04/2018.
 */
@Entity
@Data
public class ParagraphEntity {
    @Id
    private Long paragraphId;
    @ManyToOne()
    @JoinColumn(name = "questionEntityId")
    private QuestionEntity questionEntity;
}
