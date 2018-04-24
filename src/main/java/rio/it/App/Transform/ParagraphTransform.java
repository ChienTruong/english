package rio.it.App.Transform;

import rio.it.App.Entity.ParagraphEntity;
import rio.it.App.Model.ParagraphModel;

public interface ParagraphTransform {

    /**
     * convert ParagraphModel To ParagraphEntity
     * @param paragraphModel
     * @return paragraphEntity
     * @author Quang Lai
     */
    ParagraphEntity convertParagraphModelToEntity(ParagraphModel paragraphModel);


    /**
     * convert paragraphEntity to paragraphModel
     * @param paragraphEntity
     * @return paragraphModel
     * @author Quang Lai
     */
    ParagraphModel convertParagraphEntityToModel(ParagraphEntity paragraphEntity);


}
