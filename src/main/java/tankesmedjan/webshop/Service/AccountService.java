package tankesmedjan.webshop.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    public Account addAccount(Account account) {
        accountRepo.save(account);
        return account;
    }

    public List<Account> getAccounts() {
        return accountRepo.findAll();
    }

    public Account saveAccount(Account account) {
        accountRepo.save(account);
        return account;
    }


}
