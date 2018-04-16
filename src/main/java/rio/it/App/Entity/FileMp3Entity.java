package rio.it.App.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class FileMp3Entity {
    @Id
    @GeneratedValue()
    private Long fileMp3Id;
    private String pathFileMp3;

}
