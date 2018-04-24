package rio.it.App.Transform;

import rio.it.App.Entity.FileImageEntity;
import rio.it.App.Model.FileImageModel;

public interface FileImageTransform {

    /**
     * convert FileImageModel to FileImageEntity
     * @param fileImageModel
     * @return FileImageEntity
     * @author Quang Lai
     */
    FileImageEntity convertFileImageModelToEntity(FileImageModel fileImageModel);

    /**
     * convert FileImageEntity to FileImageModel
     * @param fileImageEntity
     * @return FileImageModel
     * @author Quang Lai
     */
    FileImageModel convertFileImageEntityToModel(FileImageEntity fileImageEntity);

}
