package tankesmedjan.webshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tankesmedjan.webshop.dto.AccountAndCostumerCreationDTO;
import tankesmedjan.webshop.models.Account;
import tankesmedjan.webshop.models.Customers;
import tankesmedjan.webshop.repos.AccountRepo;
import tankesmedjan.webshop.repos.CustomersRepo;

import java.util.List;

@Service
public class AccountService {


    private AccountRepo accountRepo;

    @Autowired
    private CustomersService customersService;

    @Autowired
    public AccountService(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }

    public List<Account> getAccounts() {
        return accountRepo.findAll();
    }

    public AccountAndCostumerCreationDTO saveAccount(AccountAndCostumerCreationDTO accountAndCostumerCreationDTO) {
        Account createNewAccount = new Account(accountAndCostumerCreationDTO);
        accountRepo.save(createNewAccount);
        accountAndCostumerCreationDTO.setAccount_id(createNewAccount.getId());

        Customers customers = new Customers(accountAndCostumerCreationDTO);
        customersService.addCustomers(customers);

        return accountAndCostumerCreationDTO;

    }

    public Boolean checkAuth(String username, String password) {
        if (accountRepo.findAccountByUsernameAndPassword(username, password).isEmpty()) return false;
        return true;
    }

    public List<Account> getUserData(String username, String password) {
        return accountRepo.findAccountByUsernameAndPassword(username, password);
    }


}

