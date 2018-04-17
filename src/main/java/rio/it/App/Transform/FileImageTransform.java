package rio.it.App.Transform;

import rio.it.App.Entity.FileImageEntity;
import rio.it.App.Dto.FileImageDto;

public interface FileImageTransform {

    /**
     * convert FileImageDto to FileImageEntity
     * @param fileImageDto
     * @return FileImageEntity
     * @author Quang Lai
     */
    FileImageEntity convertFileImageDtoToEntity(FileImageDto fileImageDto);

    /**
     * convert FileImageEntity to FileImageDto
     * @param fileImageEntity
     * @return FileImageDto
     * @author Quang Lai
     */
    FileImageDto convertFileImageEntityToDto(FileImageEntity fileImageEntity);

}
