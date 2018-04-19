package rio.it.App.Transform.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import rio.it.App.Dto.AccountDto;
import rio.it.App.Entity.AccountEntity;
import rio.it.App.Transform.AccountTransform;

import java.util.ArrayList;

@Service
public class AccountTransformIpm implements AccountTransform {

    Logger logger = LoggerFactory.getLogger(AccountTransformIpm.class);


    @Override
    public AccountDto convertAccountEntityToDto(AccountEntity accountEntity) {

        AccountDto accountDto =null;
        logger.info("Begin convert AccountEntity To Dto with Entity"+accountEntity);
        if(accountEntity != null){
            accountDto = new AccountDto();
            accountDto.setEmail(accountEntity.getEmail());
        }
        logger.info("End convert AccountEntity To Dto with result"+accountDto);
        return accountDto;
    }

    @Override
    public AccountEntity convertAccountDtoToEntity(AccountDto accountDto) {

        AccountEntity accountEntity =null;
        logger.info("Begin convert AccountDto To Entity with "+accountDto);
        if (accountDto != null){
            accountEntity = new AccountEntity();
            accountEntity.setEmail(accountDto.getEmail());
            accountEntity.setPwd(accountDto.getPwd());
        }
        logger.info("End convert AccountDto To Entity with result"+accountEntity);
        return accountEntity;
    }
}
