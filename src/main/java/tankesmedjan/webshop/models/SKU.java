package tankesmedjan.webshop.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tankesmedjan.webshop.dto.AddProductDTO;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class SKU {

    public SKU(AddProductDTO sku) {
        this.sku = sku.getSku();
        this.stock = sku.getStock();
        this.attributeOption = new AttributeOption();
        this.attributeOption.setId(sku.getAttributeOptionId());
        this.product = new Product();
        this.product.setId(sku.getProductId());
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String sku;

    private int stock;
    private Double priceDiff;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attributeOptionId", nullable = true)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private AttributeOption attributeOption;


}
