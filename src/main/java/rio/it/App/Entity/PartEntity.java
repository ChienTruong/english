package rio.it.App.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chien on 06/04/2018.
 */
@Entity
@Data
public class PartEntity {
    @Id
    private Long partId;
    private String partName;
    @OneToMany(mappedBy = "partEntity")
    private List<QuestionEntity> questionEntityList = new ArrayList<>(0);
}
