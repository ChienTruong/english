package rio.it.App.Util.Impl;

import org.springframework.web.multipart.MultipartFile;
import rio.it.App.Dto.ParagraphDto;
import rio.it.App.Dto.QuestionDto;
import rio.it.App.Dto.SubQuestionDto;
import rio.it.App.Util.VerifyPartQuestion;

import java.util.List;


/**
 * Created by CongN on 12/04/2018.
 */
public class VerifyQuestionPartThree extends VerifyPartQuestionGeneric implements VerifyPartQuestion {

    public VerifyQuestionPartThree(int maxSizeOfQuestionList, int minSizeOfSubQuestionList, int sizeOfSentenceList) {
        super(maxSizeOfQuestionList, minSizeOfSubQuestionList, sizeOfSentenceList);
    }

    @Override
    protected void doLog() {

    }

    @Override
    protected boolean verifyForFileMp3(MultipartFile multipartFile) {
        return this.verifyNotAllowNullFileMp3(multipartFile);
    }

    @Override
    protected boolean verifyForQuestionDto(QuestionDto questionDto) {
        List<ParagraphDto> paragraphDtoList = questionDto.getParagraphDtoList();
        List<SubQuestionDto> subQuestionDtoList = questionDto.getSubQuestionDtoList();
        if (!this.functionVerify.verifyListNotNullAndNotEmpty(questionDto.getFileImageDtoList())
                && this.functionVerify.verifyListNotNullAndNotEmpty(subQuestionDtoList)) {
            if (this.functionVerify.verifyListNotNullAndNotEmpty(paragraphDtoList)) {
                if (!this.verifyForParagraphDto(paragraphDtoList.get(0))) {
                    return false;
                }
            }
            if (this.verifyForSubQuestionDtoList(subQuestionDtoList)) {
                return this.filterEachInSubQuestionDtoList(subQuestionDtoList);
            }
        }
        return false;
    }
}
