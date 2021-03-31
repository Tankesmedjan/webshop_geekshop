package tankesmedjan.webshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tankesmedjan.webshop.dto.AccountCreationDTO;
import tankesmedjan.webshop.models.Account;
import tankesmedjan.webshop.repos.AccountRepo;

import java.util.List;

@Service
public class AccountService {


    private AccountRepo accountRepo;

    @Autowired
    public AccountService(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }

    public List<Account> getAccounts() {
        return accountRepo.findAll();
    }

    public AccountCreationDTO saveAccount(AccountCreationDTO accountCreationDTO) {
        Account createNewAccount = new Account(accountCreationDTO);
        accountRepo.save(createNewAccount);
        return accountCreationDTO;
    }


}
