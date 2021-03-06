package rio.it.App.Entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by chien on 08/04/2018.
 */
@Entity
@Data
public class ParagraphEntity  extends IdEntity{

    private String paragraph;
    @ManyToOne()
    @JoinColumn(name = "questionEntityId")
    private QuestionEntity questionEntity;
}
