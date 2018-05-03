package rio.it.App.Model;

import lombok.Data;

import java.util.List;

@Data
public class AccountModel extends IdModel{

    private String email;
    private String pwd;
    private List<PartQuestionModel> partQuestionModelList;
}
