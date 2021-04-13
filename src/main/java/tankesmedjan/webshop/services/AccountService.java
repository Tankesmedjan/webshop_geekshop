package tankesmedjan.webshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tankesmedjan.webshop.dto.AccountAndCostumerCreationDTO;
import tankesmedjan.webshop.mappers.AccountMapper;
import tankesmedjan.webshop.mappers.CustomerMapper;
import tankesmedjan.webshop.models.Account;
import tankesmedjan.webshop.models.Customer;
import tankesmedjan.webshop.repos.AccountRepo;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepo accountRepo;

    private final CustomerService customerService;

    @Autowired
    public AccountService(AccountRepo accountRepo, CustomerService customerService) {
        this.accountRepo = accountRepo;
        this.customerService = customerService;
    }

    public List<Account> getAccounts() {
        return accountRepo.findAll();
    }

    public AccountAndCostumerCreationDTO saveAccount(AccountAndCostumerCreationDTO accountAndCostumerCreationDTO){
        Account createNewAccount = AccountMapper.INSTANCE.dtoToAccount(accountAndCostumerCreationDTO);
        accountRepo.save(createNewAccount);
        accountAndCostumerCreationDTO.setAccount_id(createNewAccount.getId());

        Customer customer = CustomerMapper.INSTANCE.dtoToCustomer(accountAndCostumerCreationDTO);
        customerService.addCustomer(customer);

        return accountAndCostumerCreationDTO;
    }

    public List<Account> getAccount(String id) {
        return accountRepo.getAccountById(id);
    }

    public Boolean checkAuth(String username, String password) {
        if (accountRepo.findAccountByUsernameAndPassword(username, password).isEmpty()) return false;
        return true;
    }

    public List<Account> getUserData(String username, String password) {
        return accountRepo.findAccountByUsernameAndPassword(username, password);
    }


}

