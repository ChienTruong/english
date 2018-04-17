package rio.it.App.Dto;

import lombok.Data;

/**
 * Created by ngocson on 10/04/2018.
 */
@Data
public class SentenceDto {
    private Long sentenceId;
    private String character;
    private String sentenceEn;
    private String sentenceVn;
    private SubQuestionDto subQuestionDto;

}
