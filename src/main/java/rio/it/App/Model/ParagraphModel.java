package rio.it.App.Model;

import lombok.Data;

/**
 * Created by ngocson on 10/04/2018.
 */
@Data
public class ParagraphModel {

    private Long paragraphId;
    private String paragraph;
    private QuestionModel questionModel;
}
