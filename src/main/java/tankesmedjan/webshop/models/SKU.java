package tankesmedjan.webshop.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class SKU {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String sku;

    private int stock;
    private Double price_diff;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sku")
    @JsonIgnore
    private List<Products> product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attributeoptionsid", nullable = true)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private AttributeOptions attributeOptions;
}
