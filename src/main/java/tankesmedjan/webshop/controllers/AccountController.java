package tankesmedjan.webshop.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tankesmedjan.webshop.Service.AccountService;
import tankesmedjan.webshop.models.Account;
import tankesmedjan.webshop.models.Products;
import tankesmedjan.webshop.repos.AccountRepo;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    public List<Account> getAccounts() {
        return accountService.getAccounts();
    }

    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        accountService.saveAccount(account);
        return account;
    }
}
