package tankesmedjan.webshop.services;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tankesmedjan.webshop.dto.AccountAndCostumerCreationDTO;
import tankesmedjan.webshop.models.Account;
import tankesmedjan.webshop.models.Customer;
import tankesmedjan.webshop.repos.AccountMapper;
import tankesmedjan.webshop.repos.AccountRepo;
import tankesmedjan.webshop.repos.CategoryMapper;
import tankesmedjan.webshop.repos.CustomerMapper;

import java.util.List;

@Service
public class AccountService {


    private AccountRepo accountRepo;

    @Autowired
    private CustomerService customerService;

    @Autowired
    public AccountService(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }

    public List<Account> getAccounts() {
        return accountRepo.findAll();
    }

    public AccountAndCostumerCreationDTO saveAccount(AccountAndCostumerCreationDTO accountAndCostumerCreationDTO){
        Account createNewAccount = AccountMapper.INSTANCE.dtoToAccount(accountAndCostumerCreationDTO);
        accountRepo.save(createNewAccount);
        accountAndCostumerCreationDTO.setAccount_id(createNewAccount.getId());

        Customer customer = CustomerMapper.INSTANCE.dtoToCustomer(accountAndCostumerCreationDTO);
        customer.setAccount(createNewAccount);
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

