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
public class Brands {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 32)
    private String brand_name;

    private String brand_logo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "brands")
    @JsonIgnore
    private List<Products> products = new ArrayList<Products>();
}
