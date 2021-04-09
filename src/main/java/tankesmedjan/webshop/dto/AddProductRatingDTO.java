package tankesmedjan.webshop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddProductRatingDTO {

    private int rating;
    private String ratingmessage;

    private String account_id;
    private Long products_id;
}
