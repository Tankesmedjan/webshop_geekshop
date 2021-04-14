package tankesmedjan.webshop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRatingDTO {

    private Double rating;
    private String ratingMessage;

    private String customerId;
    private Long productId;
}
