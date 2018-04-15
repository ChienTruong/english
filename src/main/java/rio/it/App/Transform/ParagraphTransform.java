package rio.it.App.Transform;

import rio.it.App.Entity.ParagraphEntity;
import rio.it.App.Dto.ParagraphDto;

public interface ParagraphTransform {

    ParagraphEntity convertParagraphDtoToEntity(ParagraphDto paragraphDto);
    ParagraphDto    convertParagraphEntityToDto(ParagraphEntity paragraphEntity);


}
