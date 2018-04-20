package rio.it.Verify;

import java.io.IOException;

/**
 * Created by chien on 19/04/2018.
 */
public abstract class VerifyForListeningTest extends SuperVerifyTest {

    protected void init() throws IOException {
        super.init();
        this.partQuestionDto.setPathFileMp3(this.makeDataForInput.makeFileMp3(false, false));
    }
}
