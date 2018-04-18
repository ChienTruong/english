package rio.it.App.Dto;

import lombok.Data;

/**
 * Created by ngocson on 10/04/2018.
 */
@Data
public class ParagraphDto {
    private Long paragraphId;
    private String paragraph;
    private QuestionDto questionDto;

}
