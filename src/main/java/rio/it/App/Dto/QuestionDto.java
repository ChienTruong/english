package rio.it.App.Dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ngocson on 10/04/2018.
 */
@Data
public class QuestionDto {

    private Long questionEntityId;
    private List<ParagraphDto> paragraphDtoList ;
    private List<FileImageDto> fileImageDtoList ;
    private List<SubQuestionDto> subQuestionDtoList;
    private Integer timeEnd;
    private Integer timeStart;

}
