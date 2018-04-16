package rio.it.App.Dto;

import lombok.Data;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chien on 08/04/2018.
 */
@Data
@ToString
public class PartQuestionDto {

    private Long partQuestionId;
    private MultipartFile pathFileMp3;
    private List<QuestionDto> questionDtoList;
    private String namePart;


}
