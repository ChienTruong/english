package rio.it.App.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String email;
    private String pwd;
    @OneToMany
    private List<PartQuestionEntity> partQuestionEntities;
}
