package rio.it.App.RestController.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rio.it.App.BusinessLogic.PartBl;
import rio.it.App.Dao.PartDao;
import rio.it.App.Entity.PartEntity;
import rio.it.App.RestController.PartRest;

/*
 * Created by chien on 24/04/2018.
 */
@RestController
@RequestMapping("/api/part")
public class PartRestImpl implements PartRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(PartRestImpl.class);

    private PartBl partBl;

    @Autowired
    public PartRestImpl(PartBl partBl) {
        this.partBl = partBl;
    }

    @PreAuthorize("isAuthenticated()")
    @Override
    public ResponseEntity getPartQuestionRandom(@PathVariable(name = "namePart") String namePart,
                                                Authentication authentication) {
        LOGGER.info("Processed For Flow Get Random Part Question");
        this.partBl.getPartQuestionRandom(namePart, authentication.getName());
        return null;
    }
}
