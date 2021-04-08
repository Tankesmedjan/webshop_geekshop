package tankesmedjan.webshop.repos;

import org.springframework.data.repository.CrudRepository;
import tankesmedjan.webshop.models.Account;

import java.util.List;

public interface AccountRepo extends CrudRepository<Account, String> {

    List<Account> findAll();
    List<Account> findAccountByUsernameAndPassword(String username, String password);

}
