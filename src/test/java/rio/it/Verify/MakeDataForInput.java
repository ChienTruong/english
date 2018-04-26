package rio.it.Verify;

import org.springframework.mock.web.MockMultipartFile;
import rio.it.App.Model.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Created by chien on 19/04/2018.
 */
public class MakeDataForInput {

    private static final String pathMp3Test = "/home/chien/IdeaProjects/english/DataForTest/fileListening.mp3";
    private static final String pathImageTest = "/home/chien/IdeaProjects/english/DataForTest/fileImage.png";


    private MockMultipartFile makeMultipartFile(boolean allowNull, boolean allowEmpty, String suffix) throws IOException {
        MockMultipartFile mockMultipartFile = null;
        if (!allowNull) {
            byte[] bytes = new byte[0];
            if (!allowEmpty) {
                if (suffix.equals("mp3")) {
                    bytes = Files.readAllBytes(Paths.get(pathMp3Test));
                } else {
                    bytes = Files.readAllBytes(Paths.get(pathImageTest));
                }
            }
            mockMultipartFile = new MockMultipartFile("test", "test." + suffix, "application/octet-stream", bytes);
        }
        return mockMultipartFile;
    }

    public MockMultipartFile makeFileMp3(boolean allowNull, boolean allowEmpty) throws IOException {
        MockMultipartFile mockMultipartFile = this.makeMultipartFile(allowNull, allowEmpty, "mp3");
        return mockMultipartFile;
    }

    public QuestionModel makeQuestionModel(boolean nullListParagraph, boolean nullListFileImage) {
        QuestionModel questionModel = new QuestionModel();
        questionModel.setSubQuestionModelList(new ArrayList<>(0));
        if (!nullListFileImage) {
            questionModel.setFileImageModelList(new ArrayList<>(0));
        }
        if (!nullListParagraph) {
            questionModel.setParagraphModelList(new ArrayList<>(0));
        }
        return questionModel;
    }

    public FileImageModel makeFileImageModel(boolean allowNull, boolean allowEmpty) throws IOException {
        FileImageModel fileImageModel = new FileImageModel();
        fileImageModel.setPathFileImage(this.makeMultipartFile(allowNull, allowEmpty, "png"));
        return fileImageModel;
    }

    public SubQuestionModel makeSubQuestionModel(boolean nullAsk, boolean nullListSentence) {
        SubQuestionModel subQuestionModel = new SubQuestionModel();
        subQuestionModel.setAnswer("C");
        if (!nullAsk) {
            subQuestionModel.setSentenceAsk("Ask Sentence");
        }
        if (!nullListSentence) {
            subQuestionModel.setSentenceModelList(new ArrayList<>());
        }
        return subQuestionModel;
    }

    public SentenceModel makeSentenceModel(boolean emptySentence) {
        SentenceModel sentenceModel = new SentenceModel();
        if (!emptySentence) {
            sentenceModel.setSentenceEn("Sentence EN");
        }
        return sentenceModel;
    }

    public ParagraphModel makeParagraphModel(boolean allowEmpty) {
        ParagraphModel paragraphModel = new ParagraphModel();
        if (!allowEmpty) {
            paragraphModel.setParagraph("Paragraph");
        }
        return paragraphModel;
    }
}
