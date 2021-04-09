package tankesmedjan.webshop.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import tankesmedjan.webshop.dto.AddProductRatingDTO;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ProductRating {

    public ProductRating(AddProductRatingDTO productRating) {

        this.rating = productRating.getRating();
        this.ratingmessage = productRating.getRatingmessage();

        this.products = new Products();
        this.products.setId(productRating.getProducts_id());

        this.account = new Account();
        this.account.setId(productRating.getAccount_id());
    }


    @Id
    @Column(length = 10)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 1)
    private int rating;

    @Type(type = "text")
    private String ratingmessage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "products_id", nullable = true)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Products products;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = true)
    @JsonIgnoreProperties({"hibernateLazyIntitializer", "handler"})
    private Account account;

}
