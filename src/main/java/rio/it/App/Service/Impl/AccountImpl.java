package rio.it.App.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rio.it.App.Dto.AccountDto;
import rio.it.App.Repository.AccountRepository;
import rio.it.App.Service.AccountSevice;
import rio.it.App.Transform.AccountTransform;

import java.util.ArrayList;
import java.util.List;
@Service
public class AccountImpl implements AccountSevice{

    AccountRepository accountRepository;
    AccountTransform accountTransform;

    @Autowired
    public AccountImpl(AccountRepository accountRepository, AccountTransform accountTransform) {
        this.accountRepository = accountRepository;
        this.accountTransform = accountTransform;
    }

    @Override
    public AccountDto findOne(Long id)  {
        if (id != null){
            AccountDto accountDto = accountTransform.convertAccountEntityToDto(accountRepository.findOne(id));
            return accountDto;
        }
        return null;
    }

    @Override
    public List<AccountDto> findAll() {
        List<AccountDto> accountDtoList = new ArrayList<>();
        accountRepository.findAll().forEach(accountEntity -> {
            AccountDto accountDto = accountTransform.convertAccountEntityToDto(accountEntity);
            accountDtoList.add(accountDto);
        });
        return accountDtoList;
    }

    @Override
    public void delete(Long id) {
        if (id != null){
            accountRepository.delete(accountRepository.findOne(id));
        }

    }

    @Override
    public boolean save(AccountDto accountDto) {
        if(accountDto != null){
            accountRepository.save(accountTransform.convertAccountDtoToEntity(accountDto));
            return true;
        }
        return false;
    }
}
