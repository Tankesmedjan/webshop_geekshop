package tankesmedjan.webshop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddProductDTO {


   private String productName;
   private String shortDesc;
   private String fullDesc;
   private double productPrice;
   private Long brandId;
   private Long vatId;
   private Long catId;

   private Long productId;
   private String sku;
   private int stock;
   private Long attributeOptionId;

   private boolean isFeatured = false;
   private boolean hasImage = false;

}
