package rio.it.App.RestController.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rio.it.App.BusinessLogic.Impl.PartQuestionBlImpl;
import rio.it.App.Model.PartQuestionModel;
import rio.it.App.RestController.PartQuestionRest;

import java.util.List;

/**
 * Created by chien on 10/04/2018.
 */
@RestController
@RequestMapping("/partQuestion")
public class PartQuestionRestImpl implements PartQuestionRest {

    private PartQuestionBlImpl partQuestionBl;

    @Autowired
    public PartQuestionRestImpl(PartQuestionBlImpl partQuestionBl) {
        this.partQuestionBl = partQuestionBl;
    }

    @Override
    public ResponseEntity create(PartQuestionModel partQuestionModel) {
        this.partQuestionBl.createPartQuestionDto(partQuestionModel);
        return null;
    }

    @Override
    public ResponseEntity<List<PartQuestionModel>> findAll() {
        return null;
    }

    @Override
    public ResponseEntity<PartQuestionModel> findOne(@PathVariable(name = "id") Long partQuestionId) {
        return null;
    }

    @Override
    public ResponseEntity update(@PathVariable(name = "id") Long partQuestionId, @RequestBody() PartQuestionModel partQuestionModel) {
        return null;
    }

    @Override
    public ResponseEntity delete(@PathVariable(name = "id") Long partQuestionId) {
        return null;
    }
}
