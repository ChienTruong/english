package rio.it.Verify;

import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by ngocson on 23/04/2018.
 */
public class testfile {
    String OS = null;
    String osName = System.getProperty("os.name");
    String osNamecath = osName.toLowerCase();
    String n = "pArtoNe";
    String partname = n.toLowerCase();
    String characterSplit = "";
    BufferedOutputStream bufferedOutputStream = null;
    String english = "english";
    String partQuestion = "partQuestion";
    String image = "image";

    @Test
    public void getsystem() throws IOException {
        byte[] bytes = new byte[1];
        byte[] bytes1 = new byte[1];

        MockMultipartFile mockMultipartFile =
                new MockMultipartFile(
                        "music",
                        "Image." + "mp3",
                        "application/octet-stream",
                        bytes);
        String[] splitOfname = mockMultipartFile.getOriginalFilename().split("\\.");
        String suff = splitOfname[splitOfname.length - 1];

        MockMultipartFile mockMultipartFile1 =
                new MockMultipartFile(
                        "test",
                        "test." + "png",
                        "application/octet-stream",
                        bytes1);
        String[] splitOfname1 = mockMultipartFile1.getOriginalFilename().split("\\.");
        String suff1 = splitOfname1[splitOfname1.length - 1];

        if (osNamecath.contains("linux")) {
            OS = System.getProperty("user.home");
            characterSplit = "/";
            Path path = Paths.get(OS + characterSplit + english + characterSplit + partQuestion);

            if (!Files.exists(path)) {
                Files.createDirectories(path);
                System.out.println("Create lai file");
            }

            if (suff.equals("mp3")) {

                bufferedOutputStream = new BufferedOutputStream(
                        new FileOutputStream(new File(path + characterSplit + mockMultipartFile.getOriginalFilename())));
                System.out.println("MP3");
            }else
            /*if (suff1.equals("png"))*/{
                Path path1 = Paths.get(path+characterSplit+image);
                if (!Files.exists(path1)) {
                    Files.createDirectories(path1);
                    System.out.println("Create PNG");
                }
                bufferedOutputStream = new BufferedOutputStream(
                        new FileOutputStream(new File(path1 +characterSplit+ mockMultipartFile.getOriginalFilename())));
                System.out.println("PNG");
            }
        } else if (osNamecath.contains("windows")) {
            OS = System.getProperty("user.home");
            characterSplit = "\\";

        } else if (osNamecath.contains("mac os")) {
            OS = System.getProperty("os.name") + System.getProperty("user.name");
        }

        System.out.println(mockMultipartFile.getBytes());

        bufferedOutputStream.write(mockMultipartFile.getBytes());
        bufferedOutputStream.close();


//        System.out.println(System.getProperty("os.name"));
//        System.out.println(System.getProperty("os.arch"));
//        System.out.println(System.getProperty("user.home"));
    }
}
