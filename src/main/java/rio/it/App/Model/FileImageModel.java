package rio.it.App.Model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by ngocson on 10/04/2018.
 */
@Data
public class FileImageModel {

    private Long fileImageId;
    private MultipartFile pathFileImage;
    private QuestionModel questionModel;
}
