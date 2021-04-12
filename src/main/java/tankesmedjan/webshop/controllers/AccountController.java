package tankesmedjan.webshop.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import tankesmedjan.webshop.dto.AccountAndCostumerCreationDTO;
import tankesmedjan.webshop.models.Account;
import tankesmedjan.webshop.services.AccountService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    public List<Account> getAccounts() {
        return accountService.getAccounts();
    }

    @PostMapping
    public AccountAndCostumerCreationDTO createAccount(@RequestBody AccountAndCostumerCreationDTO account) {
        accountService.saveAccount(account);
        return account;
    }

    @PostMapping("/auth")
    public Boolean checkAuth(@RequestBody Account account) {
        String username = account.getUsername();
        String password = account.getPassword();
       return accountService.checkAuth(username, password);
    }

    @GetMapping("/auth/userdata")
    public List<Account> getUserData(@Param("id") String id) {
        return accountService.getAccount(id);
    }

    @PostMapping("/auth/userdata")
    public List<Account> getUserData(@RequestBody Account account) {
        String username = account.getUsername();
        String password = account.getPassword();
       return accountService.getUserData(username, password);
    }
}
