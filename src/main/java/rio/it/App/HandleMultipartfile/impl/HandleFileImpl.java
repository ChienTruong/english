package rio.it.App.HandleMultipartfile.impl;

import org.springframework.stereotype.Component;
import rio.it.App.Dto.PartQuestionDto;
import rio.it.App.Entity.PartQuestionEntity;
import rio.it.App.HandleMultipartfile.HandleFile;

import java.io.*;

/**
 * Created by ngocson on 23/04/2018.
 */
@Component
public class HandleFileImpl implements HandleFile {


    @Override
    public void dosomething(PartQuestionEntity partQuestionEntity, PartQuestionDto partQuestionDto) {
        String pathname = null;
        String osName = System.getProperty("os.name");
        String osNamecath = osName.toLowerCase();
        String fileName = null;
        try {

            if (partQuestionDto.getPathFileMp3().getSize() > 1) {
                fileName = partQuestionDto.getPathFileMp3().getOriginalFilename();
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
                        new FileOutputStream(new File("/home/ngocson/" + fileName)));

                partQuestionEntity.setPathFileMp3(pathname);

                bufferedOutputStream.write(partQuestionDto.getPathFileMp3().getBytes());
                bufferedOutputStream.close();

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}

