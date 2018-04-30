package rio.it.App.HandleMultipartfile.impl;

import org.springframework.stereotype.Component;
import rio.it.App.Entity.FileImageEntity;
import rio.it.App.Entity.PartQuestionEntity;
import rio.it.App.HandleMultipartfile.HandleFile;
import rio.it.App.Model.FileImageModel;
import rio.it.App.Model.PartQuestionModel;
import rio.it.App.Model.QuestionModel;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by ngocson on 23/04/2018.
 */
@Component
public class HandleFileImpl implements HandleFile {

    private final static String OsName = System.getProperty("os.name").toLowerCase();
    private final String characterSplit = "/";
    private final String english = "English";
    private final String partQuestion = "partQuestion";
    private static BufferedOutputStream BUFFERED_OUTPUT_STREAM = null;

    private Path init(String partName) {
        String UserHome = System.getProperty("user.home");
        Path path = Paths.get(UserHome + characterSplit + english + characterSplit + partQuestion + characterSplit + partName);
        return path;
    }

    private void createPathMp3(PartQuestionModel partQuestionModel) {
        String partName = partQuestionModel.getNamePart().toLowerCase();
        Path path = init(partName);
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String nameMp3 = partQuestionModel.getPathFileMp3().getOriginalFilename();
        String[] splitOfName = partQuestionModel.getPathFileMp3().getOriginalFilename().split("\\.");
        String suff = splitOfName[splitOfName.length - 1];
        if (suff.equals("mp3") || suff.equals("mp4")) {
            try {
                BUFFERED_OUTPUT_STREAM = new BufferedOutputStream(new FileOutputStream(
                        new File(path + characterSplit + nameMp3)));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }


    }

    private void createImage(FileImageModel fileImageModel, String NamePart) {
        String partName = NamePart.toLowerCase();
        Path path = init(partName);
        Path path1 = Paths.get(path + characterSplit + "image");

        if (!Files.exists(path1)) {
            try {
                Files.createDirectories(path1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String fileImage = fileImageModel.getPathFileImage().getOriginalFilename();
        try {
            BUFFERED_OUTPUT_STREAM = new BufferedOutputStream(new FileOutputStream(
                    new File(path1 + characterSplit + fileImage)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        FileImageEntity fileImageEntity = new FileImageEntity();
        fileImageEntity.setPathFileImage(fileImageModel.getPathFileImage().getOriginalFilename());


    }

    @Override
    public void dosomething(PartQuestionEntity partQuestionEntity, PartQuestionModel partQuestionModel) {

        if (OsName.contains("linux")) {

            if (partQuestionModel.getPathFileMp3() != null && partQuestionModel.getPathFileMp3().getSize() > 1) {
                createPathMp3(partQuestionModel);
                partQuestionEntity.setPathFileMp3(partQuestionModel.getPathFileMp3().getOriginalFilename());
            }

            for (QuestionModel questionModel : partQuestionModel.getQuestionModelList()) {
                for (FileImageModel fileImageModel : questionModel.getFileImageModelList()) {
                    if (fileImageModel.getPathFileImage() != null && fileImageModel.getPathFileImage().getSize() > 1) {
                        createImage(fileImageModel, partQuestionModel.getNamePart());
                    }
                }
            }

        } else if (OsName.contains("windows")) {
            if (partQuestionModel.getPathFileMp3() != null && partQuestionModel.getPathFileMp3().getSize() > 1) {
                createPathMp3(partQuestionModel);
                partQuestionEntity.setPathFileMp3(partQuestionModel.getPathFileMp3().getOriginalFilename());
            }
            for (QuestionModel questionModel : partQuestionModel.getQuestionModelList()) {
                for (FileImageModel fileImageModel : questionModel.getFileImageModelList()) {
                    if (fileImageModel.getPathFileImage() != null && fileImageModel.getPathFileImage().getSize() > 1) {
                        createImage(fileImageModel, partQuestionModel.getNamePart());
                    }
                }
            }
        } else {

        }
    }
}

