package rio.it.App.RestController.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rio.it.App.BusinessLogic.PartBl;
import rio.it.App.RestController.PartRest;

/**
 * Created by chien on 24/04/2018.
 */
@RestController
@RequestMapping("/part")
public class PartRestImpl implements PartRest {

    private PartBl partBl;

    @Autowired
    public PartRestImpl(PartBl partBl) {
        this.partBl = partBl;
    }

    @Override
    public ResponseEntity getPartQuestionRandom(@PathVariable(name = "namePart") String namePart) {
        this.partBl.getPartQuestionRandom(namePart);
        return null;
    }
}
