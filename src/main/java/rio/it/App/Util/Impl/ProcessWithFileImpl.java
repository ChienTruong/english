package rio.it.App.Util.Impl;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import rio.it.App.Util.ProcessWithFile;

/**
 * Created by chien on 15/04/2018.
 */
@Component
public class ProcessWithFileImpl implements ProcessWithFile {

    @Override
    public String createPathWithFile(MultipartFile multipartFile) {
        return null;
    }
}
