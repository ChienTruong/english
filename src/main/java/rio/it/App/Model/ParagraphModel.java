package rio.it.App.Model;

import lombok.Data;

/**
 * Created by ngocson on 10/04/2018.
 */
@Data
public class ParagraphModel extends IdModel{

    private String paragraph;
    private QuestionModel questionModel;
}
