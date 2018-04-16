package rio.it.App.Transform.impl;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import rio.it.App.Dto.FileImageDto;
import rio.it.App.Entity.FileImageEntity;
import rio.it.App.Transform.FileImageTransform;


@Service
public class FileImageTransformIpm implements FileImageTransform {

    private org.slf4j.Logger logger = LoggerFactory.getLogger(FileImageTransformIpm.class);


    @Override
    public FileImageEntity convertFileImageDtoToEntity(FileImageDto fileImageDto) {
        FileImageEntity fileImageEntity =null;
        logger.info("Begin convertFileImageDtoToEntity with Dto:"+fileImageDto);
        if (fileImageDto != null){
            fileImageEntity =new FileImageEntity();
            fileImageDto.setPathFileName(fileImageDto.getPathFileName());
        }
        logger.info("End convertFileImageDtoToEntity with result:"+fileImageEntity);
        return fileImageEntity;
    }

    @Override
    public FileImageDto convertFileImageEntityToDto(FileImageEntity fileImageEntity) {
        FileImageDto fileImageDto =null;
        logger.info("Begin convertFileImageEntityToDto with Entity:"+fileImageEntity);
        if (fileImageEntity != null){
            fileImageDto = new FileImageDto();
            fileImageDto.setPathFileName(fileImageEntity.getPathFileImage());

        }
        logger.info("End convertFileImageEntityToDto with result :"+fileImageDto);
        return fileImageDto;

    }
}
