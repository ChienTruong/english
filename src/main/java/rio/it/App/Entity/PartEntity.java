package rio.it.App.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chien on 06/04/2018.
 */
@Entity
@Data
@EqualsAndHashCode
@ToString(exclude = {
        "partQuestionEntityList"
})
public class PartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long partId;
    private String partName;
    @OneToMany(mappedBy = "partEntity")
    private List<PartQuestionEntity> partQuestionEntityList = new ArrayList<>(0);
}
