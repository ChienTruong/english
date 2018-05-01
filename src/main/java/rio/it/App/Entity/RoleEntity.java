package rio.it.App.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode
@ToString(exclude = {
        "accountEntityList"
})
public class RoleEntity {

    @Id
    @GeneratedValue()
    private Long id;
    private String role;
    @ManyToMany
    private List<AccountEntity> accountEntityList;
}
