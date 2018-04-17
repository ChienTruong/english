package rio.it.App.Util.Impl;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by chien on 17/04/2018.
 */
public class FunctionVerify {

    public boolean verifyFileMp3(MultipartFile multipartFile, boolean allow) {
        return (multipartFile == null) == allow;
    }

}
