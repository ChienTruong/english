package rio.it.App.Util.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rio.it.App.Dto.*;
import rio.it.App.Util.VerifyPartQuestion;

import java.util.List;

/**
 * Created by chien on 12/04/2018.
 */
public class VerifyQuestionPartSeven implements VerifyPartQuestion {
    private Logger logger = LoggerFactory.getLogger(VerifyQuestionPartSeven.class);

    @Override
    public boolean verify(PartQuestionDto partQuestionDto) {
        logger.info("Begin Verify Part Seven with condition: " + partQuestionDto);
        if (partQuestionDto != null)
            verifyPartSeven(partQuestionDto);
        return false;

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
    }

    private boolean verifyPartSeven(PartQuestionDto partQuestionDto) {
        FunctionVerify functionVerify = new FunctionVerify();
        // Verify name part
        if (functionVerify.verifyNamePart(partQuestionDto.getNamePart())) {
            System.out.println("Verify name part");
            // verify file mp3 equal null
            if (functionVerify.verifyFileNull(partQuestionDto.getPathFileMp3())) {
                System.out.println("verify file mp3 equal null");
                List<QuestionDto> questionDtoList = partQuestionDto.getQuestionDtoList();
                // verify questionDtoList != null and size <=1
                if (functionVerify.verifyListNotNullAndNotEmpty(questionDtoList)
                        && questionDtoList.size() <= 1) {
                    System.out.println("verify questionDtoList != null and size <=1");
                    for (QuestionDto questionDto : questionDtoList) {
                        // verify paragraph == null && file image != null && subquestion != null
                        if (!functionVerify.verifyListNotNullAndNotEmpty(questionDto.getParagraphDtoList())
                                && functionVerify.verifyListNotNullAndNotEmpty(questionDto.getFileImageDtoList())
                                && functionVerify.verifyListNotNullAndNotEmpty(questionDto.getSubQuestionDtoList())) {
                            System.out.println("verify paragraph == null && file image != null && subquestion != null");
                            List<FileImageDto> fileImageDtoList = questionDto.getFileImageDtoList();
                            for (FileImageDto fileImageDto : fileImageDtoList){
                                if (functionVerify.verifySuffixOfFile(fileImageDto.getPathFileImage(),"png","jpg")){
                                    System.out.println("verify file Image is png, jpg");
                                    List<SubQuestionDto> subQuestionDtoList = questionDto.getSubQuestionDtoList();
                                    System.out.println(subQuestionDtoList);
                                    // verify subQuestionDtoList != null && size >=2 && size <=5
                                    if (functionVerify.verifyListNotNullAndNotEmpty(subQuestionDtoList)
                                            && subQuestionDtoList.size() >= 2 && subQuestionDtoList.size() <= 5) {
                                        System.out.println("verify subQuestionDtoList != null && size >=2 && size <=5");
                                        for (SubQuestionDto subQuestionDto : subQuestionDtoList) {
                                            // verify answer != null
                                            System.out.println(subQuestionDto.getAnswer());
                                            if (functionVerify.verifyStringNotNullAndNoEmpty(subQuestionDto.getAnswer())) {
                                                System.out.println("verify answer != null");
                                                // verify sentence Ask != null
                                                if (functionVerify.verifyStringNotNullAndNoEmpty(subQuestionDto.getSentenceAsk())) {
                                                    System.out.println("verify sentence Ask != null");
                                                    for (SentenceDto sentenceDto : subQuestionDto.getSentenceDtoList()) {
                                                        if (functionVerify.verifyStringNotNullAndNoEmpty(sentenceDto.getSentenceEn())) {
                                                            System.out.println("verify senteceEn != null");
                                                            return true;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }


                        }
                    }
                    return true;
                }
            }
        }

        return false;
    }
}
