package rio.it.App.RestController.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rio.it.App.Dto.AccountDto;
import rio.it.App.RestController.AccountRest;
import rio.it.App.Service.AccountSevice;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountRestImpl implements AccountRest {

    @Autowired
    private AccountSevice accountSevice;

    @Override
    public ResponseEntity create(@RequestBody AccountDto accountDto) {
        System.out.println(accountDto);

        if(accountSevice.save(accountDto)){
            return ResponseEntity.ok(accountDto);
        }

        return null;
    }

    @Override
    public List<AccountDto> findAll() {
        return accountSevice.findAll();
    }

    @Override
    public ResponseEntity findOne(Long aLong) {
        if (aLong != null) {
            AccountDto accountDto = accountSevice.findOne(aLong);
            return ResponseEntity.ok(accountDto);
        }
        return null;
    }

    @Override
    public ResponseEntity update(Long aLong, AccountDto accountDto) {

        return null;
    }

    @Override
    public ResponseEntity delete(Long aLong) {
        if (aLong!= null){
            accountSevice.delete(aLong);
        }
        return null;
    }
}
