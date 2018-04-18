package rio.it.App.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class RoleEntity {

    @Id
    @GeneratedValue()
    private Long id;
    private String role;

}
