package tankesmedjan.webshop.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.hash.Hashing;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import tankesmedjan.webshop.dto.AccountCreationDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.nio.charset.StandardCharsets;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Account {

    public Account(AccountCreationDTO accounts) {

        String sha256hex = Hashing.sha256()
                .hashString(accounts.getPassword(), StandardCharsets.UTF_8)
                .toString();

        this.username = accounts.getUsername();
        this.password = sha256hex;
        this.role = accounts.getRole();
    }

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private String username;
    private String password;
    private String role;

    @OneToOne
    @JsonIgnore
    private Customers customer;

}
