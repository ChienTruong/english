package rio.it.App.Entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * Created by chien on 10/04/2018.
 */
@Entity
@Data
@ToString(exclude = {
        "partEntity",
        "accountEntity"
})
public class PartQuestionEntity {

    @Id
    @GeneratedValue
    private Long partQuestionId;
    private String pathFileMp3;
    private Boolean status;
    @OneToMany(mappedBy = "partQuestionEntity", cascade = CascadeType.ALL)
    private List<QuestionEntity> questionEntityList;
    @ManyToOne
    @JoinColumn(name = "partId")
    private PartEntity partEntity;
    @ManyToOne()
    @JoinColumn(name = "accountID")
    private AccountEntity accountEntity;

}
