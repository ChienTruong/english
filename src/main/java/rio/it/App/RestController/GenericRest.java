package rio.it.App.RestController;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by chien on 10/04/2018.
 */
public interface GenericRest<D, ID> {

    @PostMapping("")
    ResponseEntity create(@RequestBody() D d/*, Authentication authentication*/);

    @GetMapping()
    ResponseEntity<List<D>> findAll();

    @GetMapping("/{id}")
    ResponseEntity<D> findOne(@PathVariable(name = "id") ID id);

    @PutMapping("/{id}")
    ResponseEntity update(@PathVariable(name = "id") ID id, @RequestBody() D d);

    @DeleteMapping("/{id}")
    ResponseEntity delete(@PathVariable(name = "id") ID id);
}
