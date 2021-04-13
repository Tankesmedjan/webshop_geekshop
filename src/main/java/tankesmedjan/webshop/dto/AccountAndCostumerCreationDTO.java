package tankesmedjan.webshop.dto;

import com.google.common.hash.Hashing;
import lombok.Getter;
import lombok.Setter;

import java.nio.charset.StandardCharsets;

@Getter
@Setter
public class AccountAndCostumerCreationDTO {

    /**
     * Account DTO
     */

    private String username;
    private String password;
    private String role;

    public void setPassword(String password) {
        String sha256hex = Hashing.sha256()
                .hashString(password, StandardCharsets.UTF_8)
                .toString();
        this.password = sha256hex;
    }

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
