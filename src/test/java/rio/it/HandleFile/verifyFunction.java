package rio.it.HandleFile;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import rio.it.App.Model.FileImageModel;
import rio.it.App.Model.PartQuestionModel;
import rio.it.App.Model.QuestionModel;
import rio.it.App.Service.PartQuestionService;
import rio.it.EnglishApplicationTests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ngocson on 25/04/2018.
 */
public class verifyFunction extends EnglishApplicationTests {
    @Autowired
    private PartQuestionService partQuestionService;
    private PartQuestionModel partQuestionModel;


    @Before
    public void initCreateMp3(){
        byte[] bytes = new byte[2];
        MockMultipartFile mockMultipartFile =
                new MockMultipartFile(
                        "music",
                        "music." + "mp3",
                        "application/octet-stream",
                        bytes);
        byte[] bytes1 = new byte[2];
        MockMultipartFile mockMultipartFile1 =
                new MockMultipartFile(
                        "music",
                        "Image." + "png",
                        "application/octet-stream",
                        bytes1);
        partQuestionModel = new PartQuestionModel();
        partQuestionModel.setNamePart("Partone");
        partQuestionModel.setPathFileMp3(mockMultipartFile);
        FileImageModel fileImageModel = new FileImageModel();
        fileImageModel.setPathFileImage(mockMultipartFile1);
        List<FileImageModel> fileImageModels = new ArrayList<>();
        fileImageModels.add(fileImageModel);
        QuestionModel questionModel = new QuestionModel();
        questionModel.setFileImageModelList(fileImageModels);
        List<QuestionModel> questionModels = new ArrayList<>();
        questionModels.add(questionModel);
        partQuestionModel.setQuestionModelList(questionModels);
    }

    @Test
    public void contextLoads() {
        partQuestionService.save(partQuestionModel);
    }

}
