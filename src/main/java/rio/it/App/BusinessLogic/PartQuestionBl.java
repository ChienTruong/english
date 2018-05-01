package rio.it.App.BusinessLogic;

import org.springframework.security.core.GrantedAuthority;
import rio.it.App.Model.PartQuestionModel;

import java.util.Collection;

/**
 * Created by chien on 23/04/2018.
 */
public interface PartQuestionBl {

    boolean createPartQuestionDto(PartQuestionModel partQuestionModel, String name, Collection<? extends GrantedAuthority> authorities);
}
