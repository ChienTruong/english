package rio.it.App.Repository.Implement;

import org.springframework.stereotype.Repository;
import rio.it.App.Entity.PartQuestionEntity;
import rio.it.App.Entity.QuestionEntity;
import rio.it.App.Repository.PartQuestionRepository;

/**
 * Created by chien on 08/04/2018.
 */
@Repository
public class PartQuestionRepositoryImpl extends GenericRepositoryImpl<PartQuestionEntity, Long> implements PartQuestionRepository {

}
