package rio.it.App.Util.Impl;

import org.springframework.web.multipart.MultipartFile;
import rio.it.App.Dto.QuestionDto;
import rio.it.App.Util.VerifyPartQuestion;


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
        if (!this.functionVerify.verifyListNotNullAndNotEmpty(questionDto.getFileImageDtoList())
                && this.functionVerify.verifyListNotNullAndNotEmpty(questionDto.getSubQuestionDtoList())) {
            if (this.verifyForSubQuestionDtoList(questionDto.getSubQuestionDtoList())) {
                return true;
            }
        }
        return false;
    }
//
//    @Override
//    public boolean verify(PartQuestionDto partQuestionDto) {
//        System.out.println("Three");
//
//
//        return false;
//    }
//
//    private boolean verifyPartQuestionThree(PartQuestionDto partQuestionDto){
//        FunctionVerify functionVerify = new FunctionVerify();
//        if(partQuestionDto != null){
//            if(functionVerify.verifyStringNotNullAndNoEmpty(partQuestionDto.getNamePart())){
//                if(functionVerify.verifyFileNull(partQuestionDto.getPathFileMp3())){
//                    if(functionVerify.verifySuffixOfFile(partQuestionDto.getPathFileMp3(), "mp3")
//                            && functionVerify.verifySizeOfFile(partQuestionDto.getPathFileMp3())){
//                        List<QuestionDto> questionDtoList = partQuestionDto.getQuestionDtoList();
//                        if(functionVerify.verifyListNotNullAndNotEmpty(questionDtoList)
//                                && questionDtoList.size() <= 30 ){
//                            for(QuestionDto questionDto : questionDtoList){
//                                if(!functionVerify.verifyListNotNullAndNotEmpty(questionDto.getParagraphDtoList())){
//
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return false;
//    }
}
