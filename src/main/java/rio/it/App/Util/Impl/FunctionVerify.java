package rio.it.App.Util.Impl;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by chien on 17/04/2018.
 */
public class FunctionVerify {

    public boolean verifyFileNull(MultipartFile multipartFile) {
        return multipartFile == null ? true : false;
    }

    public boolean verifySizeOfFile(MultipartFile multipartFile) {
        return multipartFile.getSize() < 1 ? false : true;
    }

    public boolean verifySuffixOfFile(MultipartFile multipartFile, String... type) {
        String[] splitOfName = multipartFile.getOriginalFilename().split("\\.");
        String suffixOfFile = splitOfName[splitOfName.length - 1];
        for (String s : type) {
            if (s.toUpperCase().equals(suffixOfFile.toUpperCase())) {
                return true;
            }
        }
        return false;
    }

    public boolean verifyStringNotNullAndNoEmpty(String string) {
        if (string != null) {
            if (!string.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public boolean verifyListNotNullAndNotEmpty(List<? extends Object> list) {
        if (list != null) {
            if (!list.isEmpty()) {
                return true;
            }
        }
        return false;
    }
}
