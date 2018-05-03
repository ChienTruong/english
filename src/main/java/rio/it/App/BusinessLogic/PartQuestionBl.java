package rio.it.App.BusinessLogic;

import rio.it.App.Model.PartQuestionModel;

/**
 * Created by chien on 23/04/2018.
 */
public interface PartQuestionBl {

    boolean createPartQuestionDto(PartQuestionModel partQuestionModel/*, String name, Collection<? extends GrantedAuthority> authorities*/);

    void update(Long partQuestionId, PartQuestionModel partQuestionModel);
}
