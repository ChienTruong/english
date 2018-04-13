package rio.it.App.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class AccountEntity {
    @Id
    @GeneratedValue()
    private  Long id;
    private String email;
    private String pwd;
    @OneToMany
    private List<PartQuestionEntity> partQuestionEntities;
}
