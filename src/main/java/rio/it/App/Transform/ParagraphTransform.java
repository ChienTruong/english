package rio.it.App.Transform;

import rio.it.App.Dto.ParagraphDto;
import rio.it.App.Entity.ParagraphEntity;

/**
 * Created by chien on 15/04/2018.
 */
public interface ParagraphTransform {

    ParagraphEntity convertParagraphDtoToEntity(ParagraphDto paragraphDto);
}
