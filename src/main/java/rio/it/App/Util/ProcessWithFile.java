package rio.it.App.Util;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by chien on 15/04/2018.
 */
public interface ProcessWithFile {

    void saveFile(String fullPathFile, MultipartFile multipartFile) throws IOException;
}
