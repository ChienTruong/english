package rio.it.App.RestController.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import rio.it.App.BusinessLogic.Impl.PartQuestionBlImpl;
import rio.it.App.Model.PartQuestionModel;
import rio.it.App.RestController.PartQuestionRest;

import java.net.URI;
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

    /**
     * @note it will return url of object just have been created, it necessary for direction to new url
     * show information of object is crated
     * @param partQuestionModel
     * @return
     */
    @Override
    public ResponseEntity create(PartQuestionModel partQuestionModel
                                 /*Authentication authentication*/) {
//        if (this.partQuestionBl.createPartQuestionDto(partQuestionModel, authentication.getName(), authentication.getAuthorities())) {
//            URI location = ServletUriComponentsBuilder
//                    .fromCurrentRequest().path("/{id}")
//                    .buildAndExpand(partQuestionModel.getPartQuestionId()).toUri();
//            return ResponseEntity.created(location).build();
//        }
        partQuestionBl.createPartQuestionDto(partQuestionModel);
        return ResponseEntity.badRequest().build();
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

    @Override
    public ResponseEntity getRandom(@PathVariable(name = "partName") String partName) {

        return null;
    }
}
