package rio.it.App.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by chien on 10/04/2018.
 */
@Entity
@Data
public class PartQuestionEntity {

    @Id
    @GeneratedValue
    private Long partQuestionId;
    private String pathFileMp3;
    private Boolean status;
    @OneToMany(mappedBy = "partQuestionEntity")
    private List<QuestionEntity> questionEntityList;
    @ManyToOne
    @JoinColumn(name = "partId")
    private PartEntity partEntity;
    @ManyToOne()
    @JoinColumn(name = "accountID")
    private AccountEntity accountEntity;

}
