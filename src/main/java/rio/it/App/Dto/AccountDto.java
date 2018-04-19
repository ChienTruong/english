package rio.it.App.Dto;

import lombok.Data;

import java.util.List;

@Data
public class AccountDto {

    private String email;
    private String pwd;
    private List<PartQuestionDto> partQuestionDtoList;
}
