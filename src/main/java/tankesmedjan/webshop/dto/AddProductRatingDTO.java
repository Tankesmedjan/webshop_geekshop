package tankesmedjan.webshop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddProductRatingDTO {

    private int rating;
    private String ratingMessage;

    private String accountId;
    private Long productId;
}
