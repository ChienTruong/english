package rio.it.Verify;

import org.springframework.mock.web.MockMultipartFile;
import rio.it.App.Dto.*;

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

    public QuestionDto makeQuestionDto(boolean nullListParagraph, boolean nullListFileImage) {
        QuestionDto questionDto = new QuestionDto();
        questionDto.setSubQuestionDtoList(new ArrayList<>(0));
        if (!nullListFileImage) {
            questionDto.setFileImageDtoList(new ArrayList<>(0));
        }
        if (!nullListParagraph) {
            questionDto.setParagraphDtoList(new ArrayList<>(0));
        }
        return questionDto;
    }

    public FileImageDto makeFileImageDto(boolean allowNull, boolean allowEmpty) throws IOException {
        FileImageDto fileImageDto = new FileImageDto();
        fileImageDto.setPathFileImage(this.makeMultipartFile(allowNull, allowEmpty, "png"));
        return fileImageDto;
    }

    public SubQuestionDto makeSubQuestionDto(boolean nullAsk, boolean nullListSentence) {
        SubQuestionDto subQuestionDto = new SubQuestionDto();
        subQuestionDto.setAnswer('C');
        if (!nullAsk) {
            subQuestionDto.setSentenceAsk("Ask Sentence");
        }
        if (!nullListSentence) {
            subQuestionDto.setSentenceDtoList(new ArrayList<>());
        }
        return subQuestionDto;
    }

    public SentenceDto makeSentenceDto(boolean emptySentence) {
        SentenceDto sentenceDto = new SentenceDto();
        if (!emptySentence) {
            sentenceDto.setSentenceEn("Sentence EN");
        }
        return sentenceDto;
    }

    public ParagraphDto makeParagraphDto(boolean allowEmpty) {
        ParagraphDto paragraphDto = new ParagraphDto();
        if (!allowEmpty) {
            paragraphDto.setParagraph("Paragraph");
        }
        return paragraphDto;
    }
}
