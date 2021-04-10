package tankesmedjan.webshop.models;


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
        this.ratingMessage = productRating.getRatingMessage();

        this.product = new Product();
        this.product.setId(productRating.getProductId());

        this.account = new Account();
        this.account.setId(productRating.getAccountId());
    }


    @Id
    @Column(length = 10)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 1)
    private int rating;

    @Type(type = "text")
    private String ratingMessage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId", nullable = true)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accountId", nullable = true)
    @JsonIgnoreProperties({"hibernateLazyIntitializer", "handler"})
    private Account account;

}
