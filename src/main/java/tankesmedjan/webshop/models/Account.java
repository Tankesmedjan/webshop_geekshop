package tankesmedjan.webshop.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tankesmedjan.webshop.dto.AccountCreationDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Account {

    public Account(AccountCreationDTO accounts) {

        this.username = accounts.getUsername();
        this.password = accounts.getPassword();
        this.role = accounts.getRole();
    }

    @Id
    @GeneratedValue
    private long id;

    private String username;
    private String password;
    private String role;

}
