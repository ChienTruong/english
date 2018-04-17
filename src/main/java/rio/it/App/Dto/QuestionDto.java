package rio.it.App.Dto;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ngocson on 10/04/2018.
 */
@Data
public class QuestionDto {

    private Long questionEntityId;
    private List<ParagraphDto> paragraphDtoList;
    private List<FileImageDto> fileImageDtoList;
    private List<SubQuestionDto> subQuestionDtoList;

    public int getSizeOfAllImage() {
        int sum = 0;
        for (FileImageDto fileImageDto : fileImageDtoList) {
            sum += fileImageDto.getPathFileImage().getSize();
        }
        return sum;
    }

}