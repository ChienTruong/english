package rio.it.App.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class AccountEntity {

    @Id
    @GeneratedValue()
    private Long id;
    private String email;
    private String pwd;
    private Boolean enable = Boolean.FALSE;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "ACCOUNT_ROLE",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<RoleEntity> roleEntityList;
    @OneToMany
    private List<PartQuestionEntity> partQuestionEntities;
}
