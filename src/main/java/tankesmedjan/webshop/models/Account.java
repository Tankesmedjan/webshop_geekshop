package tankesmedjan.webshop.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Account {

    @Id
    @GeneratedValue
    private long id;

    private String username;
    private String password;
    private String role;


}
