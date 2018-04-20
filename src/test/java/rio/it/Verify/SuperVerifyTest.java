package rio.it.Verify;

import rio.it.App.Dto.PartQuestionDto;
import rio.it.App.Util.VerifyPartQuestion;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by chien on 19/04/2018.
 */
public abstract class SuperVerifyTest {

    protected MakeDataForInput makeDataForInput = new MakeDataForInput();
    protected VerifyPartQuestion verifyPartQuestion;
    protected PartQuestionDto partQuestionDto;

    protected void init() throws IOException {
        this.partQuestionDto = new PartQuestionDto();
        this.partQuestionDto.setNamePart("name part");
        this.partQuestionDto.setQuestionDtoList(new ArrayList<>());
    }

}
