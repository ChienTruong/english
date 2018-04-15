package rio.it.App.Transform.impl;

import org.springframework.stereotype.Service;
import rio.it.App.Dto.ParagraphDto;
import rio.it.App.Entity.ParagraphEntity;
import rio.it.App.Transform.ParagraphTransform;

/**
 * Created by chien on 13/04/2018.
 */
@Service
public class ParagraphTransformImpl implements ParagraphTransform {

    @Override
    public ParagraphEntity convertParagraphDtoToEntity(ParagraphDto paragraphDto) {
        return null;
    }
}
