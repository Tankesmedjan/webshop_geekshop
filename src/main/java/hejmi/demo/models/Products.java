package hejmi.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Products {

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
