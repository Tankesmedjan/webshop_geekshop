package tankesmedjan.webshop.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @Column(length = 10)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "catid", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Category category;

    @Column(length = 32, nullable = false)
    private String productName;

    @Column(length = 128)
    private String shortDesc;

    @Type(type = "text")
    private String fullDesc;

    private Double productPrice;

    @Column(columnDefinition = "boolean default false")
    private Boolean isFeatured;

    @Column(columnDefinition = "boolean default false")
    private Boolean hasImage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brandId", nullable = true)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Brand brand;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vatId", nullable = true)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Vat vat;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    @JsonIgnore
    private List<SKU> skuList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    @JsonIgnore
    private List<ProductRating> productRatingList;

}
