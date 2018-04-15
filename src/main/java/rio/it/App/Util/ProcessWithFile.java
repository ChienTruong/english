package rio.it.App.Util;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by chien on 15/04/2018.
 */
public interface ProcessWithFile {

    String createPathWithFile(MultipartFile multipartFile);
}
