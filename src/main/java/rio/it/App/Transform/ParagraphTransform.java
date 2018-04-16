package rio.it.App.Transform;

import rio.it.App.Entity.ParagraphEntity;
import rio.it.App.Dto.ParagraphDto;

public interface ParagraphTransform {

    /**
     * convert ParagraphDto To ParagraphEntity
     * @param paragraphDto
     * @return paragraphEntity
     * @author Quang Lai
     */
    ParagraphEntity convertParagraphDtoToEntity(ParagraphDto paragraphDto);


    /**
     * convert paragraphEntity to paragraphDto
     * @param paragraphEntity
     * @return paragraphDto
     * @author Quang Lai
     */
    ParagraphDto    convertParagraphEntityToDto(ParagraphEntity paragraphEntity);


}
