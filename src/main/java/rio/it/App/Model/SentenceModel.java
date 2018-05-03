package rio.it.App.Model;

import lombok.Data;

/**
 * Created by ngocson on 10/04/2018.
 */
@Data
public class SentenceModel extends IdModel {

    private String character;
    private String sentenceEn;
    private String sentenceVn;
    private SubQuestionModel subQuestionModel;
}
