package tankesmedjan.webshop.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BrandsDTO {

    private String brand_name;
    private String brand_logo;

    private String category_name;
    private String product_name;
    private double product_price;
    private String attribute_option_name;
    private int stock;
}
