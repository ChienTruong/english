package rio.it.App.RestController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import rio.it.App.Model.PartQuestionModel;

/**
 * Created by chien on 10/04/2018.
 */
public interface PartQuestionRest extends GenericRest<PartQuestionModel, Long> {

    @GetMapping("/{partName}")
    ResponseEntity getRandom(@PathVariable(name = "partName") String partName);
}