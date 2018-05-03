package rio.it.App.Model;

import lombok.Data;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by chien on 08/04/2018.
 */
@Data
public class PartQuestionModel  extends IdModel{

    private MultipartFile pathFileMp3;
    private List<QuestionModel> questionModelList;
    private String namePart;
    private AccountModel accountModel;
}
