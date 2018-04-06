package rio.it.App.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by chien on 06/04/2018.
 */
@Entity
@Data
public class FileImageEntity {
    @Id
    private Long fileImageId;
    private String pathFileImage;
    @ManyToOne()
    @JoinColumn(name = "questionEntityId")
    private QuestionEntity questionEntity;
}