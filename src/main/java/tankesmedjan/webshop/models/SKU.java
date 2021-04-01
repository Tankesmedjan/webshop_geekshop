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

    public SKU(AddProductsDTO sku) {
        this.sku = sku.getSku();
        this.stock = sku.getStock();
        this.attributeOptions = new AttributeOptions();
        this.attributeOptions.setId(sku.getAttributeoptionsid());
        this.products = new Products();
        this.products.setId(sku.getProduct_id());
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String sku;

    private int stock;
    private Double price_diff;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Products products;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attributeoptionsid", nullable = true)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private AttributeOptions attributeOptions;


}
