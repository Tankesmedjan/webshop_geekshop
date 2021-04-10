package tankesmedjan.webshop.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Vat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 32)
    private String vatName;
    private int vatValue;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vat")
    @JsonIgnore
    private List<Product> product = new ArrayList<Product>();

}
