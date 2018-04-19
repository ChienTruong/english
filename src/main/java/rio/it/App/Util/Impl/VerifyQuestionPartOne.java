package rio.it.App.Util.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import rio.it.App.Dto.FileImageDto;
import rio.it.App.Dto.QuestionDto;
import rio.it.App.Dto.SentenceDto;
import rio.it.App.Dto.SubQuestionDto;
import rio.it.App.Util.VerifyPartQuestion;

import java.util.List;


/**
 * Created by chien on 12/04/2018.
 */
public class VerifyQuestionPartOne extends VerifyPartQuestionGeneric implements VerifyPartQuestion {

    private static final Logger LOGGER = LoggerFactory.getLogger(VerifyQuestionPartOne.class);

    public VerifyQuestionPartOne(int maxSizeOfQuestionList, int maxSizeOfSubQuestionList, int minSizeOfSubQuestionList, int sizeOfSentenceList, int sizeOfFileImageList) {
        super(maxSizeOfQuestionList, maxSizeOfSubQuestionList, minSizeOfSubQuestionList, sizeOfSentenceList, sizeOfFileImageList);
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
        if (!this.functionVerify.verifyListNotNullAndNotEmpty(questionDto.getParagraphDtoList())
                && this.functionVerify.verifyListNotNullAndNotEmpty(questionDto.getFileImageDtoList())
                && this.functionVerify.verifyListNotNullAndNotEmpty(questionDto.getSubQuestionDtoList())) {
            List<FileImageDto> fileImageDtoList = questionDto.getFileImageDtoList();
            List<SubQuestionDto> subQuestionDtoList = questionDto.getSubQuestionDtoList();
            if (this.doVerifyForFileImageList(fileImageDtoList)) {
                if (this.doVerifyForSubQuestionList(subQuestionDtoList)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    protected boolean verifyForSubQuestionDto(SubQuestionDto subQuestionDto) {
        if (this.functionVerify.verifyStringNotNullAndNoEmpty(subQuestionDto.getAnswer().toString())) {
            List<SentenceDto> sentenceDtoList = subQuestionDto.getSentenceDtoList();
            if (this.functionVerify.verifyListNotNullAndNotEmpty(sentenceDtoList)
                    && sentenceDtoList.size() == this.sizeOfSentenceList) {
                for (SentenceDto sentenceDto : sentenceDtoList) {
                    if (!this.verifyForSentenceDto(sentenceDto)) {
                        return false;
                    }
                }
                return true;
            } else {
                return true;
            }
        }
        return false;
    }

//    @Override
//    public boolean verify(PartQuestionDto partQuestionDto) {
//        if (partQuestionDto != null) {
//            logger.info("Begin Check Part One" + partQuestionDto);
//            if (!partQuestionDto.getQuestionDtoList().isEmpty()) {
//                QuestionDto questionDto = partQuestionDto.getQuestionDtoList().get(0);
//                FileImageDto fileImageDto = questionDto.getFileImageDtoList().get(0);
//                SubQuestionDto subQuestionDto = questionDto.getSubQuestionDtoList().get(0);
//
//                if (fileImageDto.getPathFileImage().getSize() > 0
//                        && subQuestionDto.getSentenceDtoList().size() == 4
//                        && subQuestionDto.getAnswer() != null){
//
//                    for (SentenceDto sentenceDto : subQuestionDto.getSentenceDtoList()){
//                        if (sentenceDto.getSentenceEn().isEmpty()
//                                || sentenceDto.getCharacter() == null) {
//                            return false;
//                        }
//                    }
//                    return true;
//
//                }
//            }
//        }
//        return false;
//    }
}
