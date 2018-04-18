package rio.it.App.Util.Impl;

import rio.it.App.Dto.*;
import rio.it.App.Util.VerifyPartQuestion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by CongN on 12/04/2018.
 */
public class VerifyQuestionPartThree implements VerifyPartQuestion {

    @Override
    public boolean verify(PartQuestionDto partQuestionDto) {
        System.out.println("Three");


        return false;
    }

    private boolean verifyPartQuestionThree(PartQuestionDto partQuestionDto){
        FunctionVerify functionVerify = new FunctionVerify();
        if(partQuestionDto != null){
            if(functionVerify.verifyNamePart(partQuestionDto.getNamePart())){
                if(functionVerify.verifyFileNull(partQuestionDto.getPathFileMp3())){
                    if(functionVerify.verifySuffixOfFile(partQuestionDto.getPathFileMp3(), "mp3")
                            && functionVerify.verifySizeOfFile(partQuestionDto.getPathFileMp3())){
                        List<QuestionDto> questionDtoList = partQuestionDto.getQuestionDtoList();
                        if(functionVerify.verifyListNotNullAndNotEmpty(questionDtoList)
                                && questionDtoList.size() <= 30 ){
                            for(QuestionDto questionDto : questionDtoList){
                                if(!functionVerify.verifyListNotNullAndNotEmpty(questionDto.getParagraphDtoList())){

                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
