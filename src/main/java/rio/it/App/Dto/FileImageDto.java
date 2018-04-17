package rio.it.App.Dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by ngocson on 10/04/2018.
 */
@Data
public class FileImageDto {
    private Long fileImageId;
    private MultipartFile pathFileImage;
    private String pathFileNameImage;

}
