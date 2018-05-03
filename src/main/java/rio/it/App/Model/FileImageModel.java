package rio.it.App.Model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by ngocson on 10/04/2018.
 */
@Data
public class FileImageModel extends IdModel{

    private MultipartFile pathFileImage;
    private QuestionModel questionModel;

}
