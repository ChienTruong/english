package rio.it.App.Util.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import rio.it.App.Dto.*;
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
        boolean fileMp3 = this.verifyAllowNullFileMp3(multipartFile);
        System.out.println("Part Seven Mp3: "+fileMp3);
        return this.verifyAllowNullFileMp3(multipartFile);
    }

    @Override
    protected boolean verifyForQuestionDto(QuestionDto questionDto) {
        List<ParagraphDto> paragraphDtoList = questionDto.getParagraphDtoList();
        List<FileImageDto> fileImageDtoList = questionDto.getFileImageDtoList();
        List<SubQuestionDto> subQuestionDtoList = questionDto.getSubQuestionDtoList();
        if (!this.functionVerify.verifyListNotNullAndNotEmpty(paragraphDtoList)
                && this.functionVerify.verifyListNotNullAndNotEmpty(fileImageDtoList)
                && this.functionVerify.verifyListNotNullAndNotEmpty(subQuestionDtoList)){
            if (this.verifyForFileImageDtoList(fileImageDtoList)){
                if (this.verifyForSubQuestionDtoList(subQuestionDtoList)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean verifyPartSeven(PartQuestionDto partQuestionDto) {
        FunctionVerify functionVerify = new FunctionVerify();
//        // Verify name part
//        if (functionVerify.verifyNamePart(partQuestionDto.getNamePart())) {
//            System.out.println("Verify name part");
//            // verify file mp3 equal null
//            if (functionVerify.verifyFileNull(partQuestionDto.getPathFileMp3())) {
//                System.out.println("verify file mp3 equal null");
//                List<QuestionDto> questionDtoList = partQuestionDto.getQuestionDtoList();
//                // verify questionDtoList != null and size <=1
//                if (functionVerify.verifyListNotNullAndNotEmpty(questionDtoList)
//                        && questionDtoList.size() <= 1) {
//                    System.out.println("verify questionDtoList != null and size <=1");
//                    for (QuestionDto questionDto : questionDtoList) {
//                        // verify paragraph == null && file image != null && subquestion != null
//                        if (!functionVerify.verifyListNotNullAndNotEmpty(questionDto.getParagraphDtoList())
//                                && functionVerify.verifyListNotNullAndNotEmpty(questionDto.getFileImageDtoList())
//                                && functionVerify.verifyListNotNullAndNotEmpty(questionDto.getSubQuestionDtoList())) {
//                            System.out.println("verify paragraph == null && file image != null && subquestion != null");
//                            List<FileImageDto> fileImageDtoList = questionDto.getFileImageDtoList();
//                            for (FileImageDto fileImageDto : fileImageDtoList){
//                                if (functionVerify.verifySuffixOfFile(fileImageDto.getPathFileImage(),"png","jpg")){
//                                    System.out.println("verify file Image is png, jpg");
//                                    List<SubQuestionDto> subQuestionDtoList = questionDto.getSubQuestionDtoList();
//                                    System.out.println(subQuestionDtoList);
//                                    // verify subQuestionDtoList != null && size >=2 && size <=5
//                                    if (functionVerify.verifyListNotNullAndNotEmpty(subQuestionDtoList)
//                                            && subQuestionDtoList.size() >= 2 && subQuestionDtoList.size() <= 5) {
//                                        System.out.println("verify subQuestionDtoList != null && size >=2 && size <=5");
//                                        for (SubQuestionDto subQuestionDto : subQuestionDtoList) {
//                                            // verify answer != null
//                                            System.out.println(subQuestionDto.getAnswer());
//                                            if (functionVerify.verifyStringNotNullAndNoEmpty(subQuestionDto.getAnswer())) {
//                                                System.out.println("verify answer != null");
//                                                // verify sentence Ask != null
//                                                if (functionVerify.verifyStringNotNullAndNoEmpty(subQuestionDto.getSentenceAsk())) {
//                                                    System.out.println("verify sentence Ask != null");
//                                                    for (SentenceDto sentenceDto : subQuestionDto.getSentenceDtoList()) {
//                                                        if (functionVerify.verifyStringNotNullAndNoEmpty(sentenceDto.getSentenceEn())) {
//                                                            System.out.println("verify senteceEn != null");
//                                                            return true;
//                                                        }
//                                                    }
//                                                }
//                                            }
//                                        }
//                                    }
//                                }
//                            }
//
//
//                        }
//                    }
//                    return true;
//                }
//            }
//        }

        return false;
    }
}
