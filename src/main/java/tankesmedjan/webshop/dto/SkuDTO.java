package tankesmedjan.webshop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SkuDTO {

    private String sku;
    private int stock;
    private double price_diff;
    private Long attributeOptionId;
    private Long productId;

    public SkuDTO(ProductDTO skuDTO) {
        this.sku = skuDTO.getSku();
        this.stock = skuDTO.getStock();
        this.price_diff = 0;
        this.attributeOptionId = skuDTO.getAttributeOptionId();
        this.productId = skuDTO.getProductId();
    }
}
