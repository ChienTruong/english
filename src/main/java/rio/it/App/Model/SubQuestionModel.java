package rio.it.App.Model;

import lombok.Data;

import java.util.List;

/**
 * Created by ngocson on 10/04/2018.
 */
@Data
public class SubQuestionModel extends IdModel{

    private String sentenceAsk;
    private String translateAsk;
    private String answer;
    private List<SentenceModel> sentenceModelList;
    private QuestionModel questionModel;
}
