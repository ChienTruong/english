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
public class QuestionEntity  extends IdEntity{

    private Integer timeStart;
    private Integer timeEnd;
    @OneToMany(mappedBy = "questionEntity",cascade = CascadeType.ALL)
    private List<ParagraphEntity> paragraphEntityList;
    @OneToMany(mappedBy = "questionEntity",cascade = CascadeType.ALL)
    private List<FileImageEntity> fileImageEntityList;
    @OneToMany(mappedBy = "questionEntity",cascade = CascadeType.ALL)
    private List<SubQuestionEntity> subQuestionEntityList;
    @ManyToOne
    @JoinColumn(name = "partQuestionId")
    private PartQuestionEntity partQuestionEntity;
}
