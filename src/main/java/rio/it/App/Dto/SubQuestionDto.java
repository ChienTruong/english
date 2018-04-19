package rio.it.App.Dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ngocson on 10/04/2018.
 */
@Data
public class SubQuestionDto {

    private Long subQuestionId;
    private String sentenceAsk;
    private String translateAsk;
    private String answer;

    private List<SentenceDto> sentenceDtoList;
    private QuestionDto questionDto;

}
