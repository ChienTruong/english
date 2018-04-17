package rio.it.App.Transform;

import rio.it.App.Dto.AccountDto;
import rio.it.App.Entity.AccountEntity;

public interface AccountTransform {
    /**
     * convert AccountEntity To AccountDto
     * @param accountEntity
     * @return AccountDto
     * @author Quang Lai
     */
    AccountDto convertAccountEntityToDto(AccountEntity accountEntity);

    /**
     * convert AccountDto To Entity
     * @param accountDto
     * @return AccountEntity
     * @author Quang Lai
     */
    AccountEntity convertAccountDtoToEntity(AccountDto accountDto);
}
