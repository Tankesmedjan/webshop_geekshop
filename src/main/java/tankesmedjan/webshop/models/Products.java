package tankesmedjan.webshop.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import tankesmedjan.webshop.dto.AddProductsDTO;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Products {

    public Products(AddProductsDTO products) {
        this.product_name = products.getProduct_name();
        this.short_desc = products.getShort_desc();
        this.full_desc = products.getFull_desc();
        this.product_price = products.getProduct_price();
        this.category = new Categories();
        this.category.setId(products.getCatid());
        this.vat = new Vat();
        this.vat.setId(products.getVatid());
        this.brands = new Brands();
        this.brands.setId(products.getBrandid());
        this.is_featured = products.is_featured();
        this.has_image = products.isHas_image();
    }

    @Id
    @Column(length = 10)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "catid", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Categories category;

    @Column(length = 32, nullable = false)
    private String product_name;

    @Column(length = 128)
    private String short_desc;

    @Type(type = "text")
    private String full_desc;

    private Double product_price;

    @Column(columnDefinition = "boolean default false")
    private Boolean is_featured;

    @Column(columnDefinition = "boolean default false")
    private Boolean has_image;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brandid", nullable = true)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Brands brands;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vatid", nullable = true)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Vat vat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "skuid")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private SKU sku;
}
