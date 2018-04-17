package rio.it.App.RestController.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rio.it.App.Dto.PartQuestionDto;
import rio.it.App.RestController.PartQuestionRest;
import rio.it.App.Service.PartQuestionService;

import java.util.List;

/**
 * Created by chien on 10/04/2018.
 */
@RestController
@RequestMapping("/partQuestion")
public class
PartQuestionRestImpl implements PartQuestionRest {

    private PartQuestionService partQuestionService;

    @Autowired
    public PartQuestionRestImpl(PartQuestionService partQuestionService) {
        this.partQuestionService = partQuestionService;
    }

    @Override
    public ResponseEntity create(/*@RequestBody()*/ PartQuestionDto partQuestionDto) {
        System.out.println(partQuestionDto.toString());
//        System.out.println(partQuestionDto.getQuestionDtoList().get(0).getFileImageDtoList().get(0).getPathFileImage().getSize());
//        System.out.println(partQuestionDto.getQuestionDtoList().get(1).getFileImageDtoList().get(1).getPathFileImage().getSize());
        this.partQuestionService.createPartQuestionDto(partQuestionDto);
        return null;
    }

    @Override
    public List<PartQuestionDto> findAll() {
        return null;
    }

    @Override
    public ResponseEntity findOne(@PathVariable(name = "id") Long aLong) {
        return null;
    }

    @Override
    public ResponseEntity update(@PathVariable(name = "id") Long aLong, @RequestBody() PartQuestionDto partQuestionDto) {
        return null;
    }

    @Override
    public ResponseEntity delete(@PathVariable(name = "id") Long aLong) {
        return null;
    }
}
