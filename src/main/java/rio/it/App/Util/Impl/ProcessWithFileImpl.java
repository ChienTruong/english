package rio.it.App.Util.Impl;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import rio.it.App.Util.ProcessWithFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by chien on 15/04/2018.
 */
public class ProcessWithFileImpl implements ProcessWithFile {

    @Override
    public void saveFile(String fullPathFile, MultipartFile multipartFile) throws IOException {
        FileCopyUtils.copy(multipartFile.getBytes(), Files.newOutputStream(Paths.get(fullPathFile)));
    }
}
