package hejmi.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class SKU {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sku;
    private int stock;
    private Double price_diff;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "skuid", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Products product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attributeoptions", nullable = true)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private AttributeOptions attributeOptions;
}
