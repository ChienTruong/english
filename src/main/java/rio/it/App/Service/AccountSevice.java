package rio.it.App.Service;

import rio.it.App.Dto.AccountDto;

import java.util.List;

public interface AccountSevice {
    AccountDto findOne(Long id);
    List<AccountDto> findAll();
    void delete (Long id);
    boolean save(AccountDto accountDto);
}
