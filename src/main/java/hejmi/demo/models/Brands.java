package hejmi.demo.models;

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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "brands")
    private List<Products> products = new ArrayList<Products>();
}
