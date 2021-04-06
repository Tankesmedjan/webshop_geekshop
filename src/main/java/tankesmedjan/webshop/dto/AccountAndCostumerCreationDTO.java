package tankesmedjan.webshop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountAndCostumerCreationDTO {

    /**
     * Account DTO
     */

    private String username;
    private String password;
    private String role;

    /**
     * Costumer DTO
     */

    private String firstname;
    private String lastname;
    private String address;
    private String postal;
    private String city;
    private String email;
    private String phone;

    private String account_id;

}
