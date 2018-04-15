package rio.it.App.Transform;

import rio.it.App.Entity.FileImageEntity;
import rio.it.App.Dto.FileImageDto;

public interface FileImageTransform {

    FileImageEntity convertFileImageDtoToEntity(FileImageDto fileImageDto);
    FileImageDto convertFileImageEntityToDto(FileImageEntity fileImageEntity);

}
