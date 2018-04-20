package rio.it.App.Util.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import rio.it.App.Dto.FileImageDto;
import rio.it.App.Dto.ParagraphDto;
import rio.it.App.Dto.QuestionDto;
import rio.it.App.Dto.SubQuestionDto;
import rio.it.App.Util.VerifyPartQuestion;

import java.util.List;

/**
 * Created by chien on 12/04/2018.
 */
public class VerifyQuestionPartSeven extends VerifyPartQuestionGeneric implements VerifyPartQuestion {
    private Logger logger = LoggerFactory.getLogger(VerifyQuestionPartSeven.class);

    public VerifyQuestionPartSeven(int maxSizeOfQuestionList, int maxSizeOfSubQuestionList, int minSizeOfSubQuestionList, int sizeOfSentenceList, int sizeOfFileImageList) {
        super(maxSizeOfQuestionList, maxSizeOfSubQuestionList, minSizeOfSubQuestionList, sizeOfSentenceList, sizeOfFileImageList);
    }

    @Override
    protected void doLog() {

    }

    @Override
    protected boolean verifyForFileMp3(MultipartFile multipartFile) {
        return this.verifyAllowNullFileMp3(multipartFile);
    }

    @Override
    protected boolean verifyForQuestionDto(QuestionDto questionDto) {
        List<ParagraphDto> paragraphDtoList = questionDto.getParagraphDtoList();
        List<FileImageDto> fileImageDtoList = questionDto.getFileImageDtoList();
        List<SubQuestionDto> subQuestionDtoList = questionDto.getSubQuestionDtoList();
        if (!this.functionVerify.verifyListNotNullAndNotEmpty(paragraphDtoList)
                && this.functionVerify.verifyListNotNullAndNotEmpty(fileImageDtoList)
                && this.functionVerify.verifyListNotNullAndNotEmpty(subQuestionDtoList)) {
            if (this.verifyForFileImageDtoList(fileImageDtoList)) {
                if (this.verifyForSubQuestionDtoList(subQuestionDtoList)) {
                    return true;
                }
            }
        }
        return false;
    }
//    @Override
//    public boolean verify(PartQuestionDto partQuestionDto) {
//        logger.info("Begin Verify Part Seven with condition: "+partQuestionDto);
//        if (partQuestionDto.getPathFileMp3() == null){
//            if (!partQuestionDto.getQuestionDtoList().isEmpty()){
//                for (QuestionDto questionDto : partQuestionDto.getQuestionDtoList()){
//                    System.out.println(questionDto.getFileImageDtoList().size());
//                    if (questionDto.getFileImageDtoList().size() < 0){
//                        System.out.println("Hinh ko co");
//                        return false;
//                    }
//                    System.out.println(questionDto.getSubQuestionDtoList().size());
//                    if (questionDto.getSubQuestionDtoList().size() <2 ){
//                        System.out.println("Khong du subQuestion");
//                        return false;
//                    }
//                    for (SubQuestionDto subQuestionDto : questionDto.getSubQuestionDtoList()){
//                        System.out.println(subQuestionDto.getSentenceDtoList().size());
//                        if (subQuestionDto.getSentenceDtoList().size() != 4){
//                            System.out.println("ko du 4 cau hoi");
//                            return false;
//                        }
//                    }
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
}
