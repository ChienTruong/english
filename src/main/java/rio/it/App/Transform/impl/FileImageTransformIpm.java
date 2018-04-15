package rio.it.App.Transform.impl;

import org.springframework.stereotype.Service;
import rio.it.App.Dto.FileImageDto;
import rio.it.App.Entity.FileImageEntity;
import rio.it.App.Transform.FileImageTransform;

@Service
public class FileImageTransformIpm implements FileImageTransform {
    @Override
    public FileImageEntity convertFileImageDtoToEntity(FileImageDto fileImageDto) {
        return null;
    }

    @Override
    public FileImageDto convertFileImageEntityToDto(FileImageEntity fileImageEntity) {
        return null;
    }
}
