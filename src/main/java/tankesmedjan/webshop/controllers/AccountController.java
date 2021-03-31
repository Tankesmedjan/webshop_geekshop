package tankesmedjan.webshop.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import tankesmedjan.webshop.dto.AccountCreationDTO;
import tankesmedjan.webshop.services.AccountService;
import tankesmedjan.webshop.models.Account;

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
    public AccountCreationDTO createAccount(@RequestBody AccountCreationDTO account) {
        accountService.saveAccount(account);
        return account;
    }

    @PostMapping("/auth")
    public Boolean checkAuth(@RequestBody Account account) {
        String username = account.getUsername();
        String password = account.getPassword();
       return accountService.checkAuth(username, password);
    }
}
