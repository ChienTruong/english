package rio.it.App.Transform.impl;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import rio.it.App.Model.FileImageModel;
import rio.it.App.Entity.FileImageEntity;
import rio.it.App.Transform.FileImageTransform;

import java.util.UUID;


@Service
public class FileImageTransformIpm implements FileImageTransform {

    private org.slf4j.Logger logger = LoggerFactory.getLogger(FileImageTransformIpm.class);

    @Override
    public FileImageEntity convertFileImageModelToEntity(FileImageModel fileImageModel) {
        FileImageEntity fileImageEntity =null;
        logger.info("Begin convertFileImageModelToEntity with Model:"+ fileImageModel);
        if (fileImageModel != null){
            fileImageEntity =new FileImageEntity();

        }
        logger.info("End convertFileImageModelToEntity with result:"+fileImageEntity);
        return fileImageEntity;
    }

    @Override
    public FileImageModel convertFileImageEntityToModel(FileImageEntity fileImageEntity) {
        FileImageModel fileImageModel =null;
        logger.info("Begin convertFileImageEntityToModel with Entity:"+fileImageEntity);
        if (fileImageEntity != null){
            fileImageModel = new FileImageModel();
            fileImageModel.setId(fileImageEntity.getUuid().toString());
        }
        logger.info("End convertFileImageEntityToModel with result :"+fileImageModel);
        return fileImageModel;

    }
}
