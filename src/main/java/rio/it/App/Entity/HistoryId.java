package rio.it.App.Entity;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by chien on 30/04/2018.
 */
@Embeddable
@Data
public class HistoryId implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAddition;
    @ManyToOne
    private AccountEntity accountEntity;
    @ManyToOne
    private PartQuestionEntity partQuestionEntity;

}
