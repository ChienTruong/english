package rio.it.App.Entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by chien on 30/04/2018.
 */
@AssociationOverrides(
        {
                @AssociationOverride(name = "pk.accountEntity", joinColumns = @JoinColumn(name = "accountId")),
                @AssociationOverride(name = "pk.partQuestionEntity", joinColumns = @JoinColumn(name = "partQuestionId"))
        }
)
@Entity
@Data
public class HistoryEntity {

    @EmbeddedId
    private HistoryId pk;
    private Integer numOfCorrectAnswer;
    private Integer numOfAllQuestion;
}
