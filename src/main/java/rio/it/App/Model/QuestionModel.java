package rio.it.App.Model;

import lombok.Data;

import java.util.List;

/**
 * Created by ngocson on 10/04/2018.
 */
@Data
public class QuestionModel extends IdModel {

    private Integer timeStart;
    private Integer timeEnd;
    private List<ParagraphModel> paragraphModelList;
    private List<FileImageModel> fileImageModelList ;
    private List<SubQuestionModel> subQuestionModelList;
}
