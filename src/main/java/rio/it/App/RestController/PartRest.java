package rio.it.App.RestController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by chien on 24/04/2018.
 */
public interface PartRest {

    @GetMapping("/{namePart}")
    ResponseEntity getPartQuestionRandom(@PathVariable(name = "namePart") String namePart);
}
