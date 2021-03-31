package tankesmedjan.webshop.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tankesmedjan.webshop.dto.AddProductsDTO;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class SKU {

    public  SKU(AddProductsDTO sku) {
        this.sku = sku.getSku();
        this.stock = sku.getStock();
        this.attributeOptions = new AttributeOptions();
        this.attributeOptions.setId(sku.getAttributeoptionid());
    }


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
