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
public class QuestionEntity {
    @Id
    @GeneratedValue
    private Long questionEntityId;
    @OneToMany(mappedBy = "questionEntity")
    private List<ParagraphEntity> paragraphEntityList = new ArrayList<>(0);
    @OneToMany(mappedBy = "questionEntity")
    private List<FileImageEntity> fileImageEntityList = new ArrayList(0);
    @OneToMany(mappedBy = "questionEntity")
    private List<SubQuestionEntity> subQuestionEntityList = new ArrayList<>(0);
    @ManyToOne
    @JoinColumn(name = "partQuestionId")
    private PartQuestionEntity partQuestionEntity;
}
