package rio.it.App.Entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by chien on 06/04/2018.
 */
@Entity
@Data
public class FileImageEntity {
    @Id
    @GeneratedValue
    private Long fileImageId;
    private String pathFileImage;
    @ManyToOne()
    @JoinColumn(name = "questionEntityId")
    private QuestionEntity questionEntity;
}
