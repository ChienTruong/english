package rio.it.App.Util.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rio.it.App.Dto.PartQuestionDto;
import rio.it.App.Dto.QuestionDto;
import rio.it.App.Entity.PartQuestionEntity;
import rio.it.App.Util.ProcessWithFile;

/**
 * Created by chien on 15/04/2018.
 */
@Component
public class ProcessAnotherForPartQuestionImpl {

    private ProcessWithFile processWithFile;

    @Autowired
    public ProcessAnotherForPartQuestionImpl(ProcessWithFile processWithFile) {
        this.processWithFile = processWithFile;
    }

    public void doMakePathFile(PartQuestionEntity partQuestionEntity, PartQuestionDto partQuestionDto) {
        // file mp3
        if (partQuestionDto.getPathFileMp3().getSize() != 0L) {
            String pathToFileMp3 = this.processWithFile.createPathWithFile(partQuestionDto.getPathFileMp3());
            partQuestionEntity.setPathFileMp3(pathToFileMp3);
        }
        for (QuestionDto questionDto : partQuestionDto.getQuestionDtoList()) {
//            if (questionDto.getSizeOfAllImage() == 0) {
//                break;
//            }
            // not think yet
        }
    }
}
