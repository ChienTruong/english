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
    private Integer timeStart;
    private Integer timeEnd;
    @OneToMany(mappedBy = "questionEntity")
    private List<ParagraphEntity> paragraphEntityList;
    @OneToMany(mappedBy = "questionEntity")
    private List<FileImageEntity> fileImageEntityList;
    @OneToMany(mappedBy = "questionEntity")
    private List<SubQuestionEntity> subQuestionEntityList;
    @ManyToOne
    @JoinColumn(name = "partQuestionId")
    private PartQuestionEntity partQuestionEntity;
}
