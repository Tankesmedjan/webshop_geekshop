package hejmi.demo.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;

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
    private Categories category;

    @Column(length = 32, nullable = false)
    private String product_name;
    @Column(length = 128)
    private String short_desc;
    @Type(type = "text")
    private String full_desc;

    private Double product_price;
    private int stock;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brandid",nullable = true)
    private Brands brands;
}
