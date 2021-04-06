package tankesmedjan.webshop.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SkuDTO {
    private String sku;
    private int stock;

    private String product_name;
    private double product_price;
    private String attribute_option_name;
    private String category_name;
    private String brand_name;

    public SkuDTO(String sku, String brand_name, String category_name, String product_name,
                  Double product_price, String attribute_option_name, int stock) {
        this.sku = sku;
        this.brand_name = brand_name;
        this.category_name = category_name;
        this.product_name = product_name;
        this.product_price = product_price;
        this.attribute_option_name = attribute_option_name;
        this.stock = stock;
    }
}
