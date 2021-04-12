package tankesmedjan.webshop.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tankesmedjan.webshop.dto.AccountAndCostumerCreationDTO;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Customer {

    @Id
    @Column(length = 20)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String firstname;

    @Column(length = 50)
    private String lastname;

    @Column(length = 50)
    private String address;

    @Column(length = 10)
    private String postal;

    @Column(length = 20)
    private String city;

    @Column(length = 50)
    private String email;

    @Column(length = 20)
    private String phone;

    @OneToOne
    @JsonIgnore
    private Account account;
}
