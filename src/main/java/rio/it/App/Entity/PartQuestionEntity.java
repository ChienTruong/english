package rio.it.App.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
    @OneToMany(mappedBy = "partQuestionEntity")
    private List<QuestionEntity> questionEntityList;

}
