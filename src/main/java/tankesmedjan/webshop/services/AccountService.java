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

    /**
     *
     * @param accountAndCostumerCreationDTO takes information about user for creating new account.
     * AccountMapper maps the dto:information to entities.
     *
     * Same for CustomerMapper.
     * @return
     */

    public AccountAndCostumerCreationDTO saveAccount(AccountAndCostumerCreationDTO accountAndCostumerCreationDTO){
        Account createNewAccount = AccountMapper.INSTANCE.dtoToAccount(accountAndCostumerCreationDTO);
        accountRepo.save(createNewAccount);
        accountAndCostumerCreationDTO.setAccount_id(createNewAccount.getId());

        Customer customer = CustomerMapper.INSTANCE.dtoToCustomer(accountAndCostumerCreationDTO);
        customerService.addCustomer(customer);

        return accountAndCostumerCreationDTO;
    }

    /**
     *
     * @param id the unique ID of an account
     * @return the account information for id
     */

    public List<Account> getAccount(String id) {
        return accountRepo.getAccountById(id);
    }

    /**
     *
     * @param username
     * @param password
     *
     * @return If there is no match in database for username+password with false otherwise true.
     */

    public Boolean checkAuth(String username, String password) {
        return !accountRepo.findAccountByUsernameAndPassword(username, password).isEmpty();
    }

    /**
     *
     * @param username
     * @param password
     * @return object of the logged in account
     */

    public List<Account> getUserData(String username, String password) {
        return accountRepo.findAccountByUsernameAndPassword(username, password);
    }


}

