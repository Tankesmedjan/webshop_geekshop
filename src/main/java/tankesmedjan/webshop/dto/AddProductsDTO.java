package tankesmedjan.webshop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddProductsDTO {

   private String product_name;
   private String short_desc;
   private String full_desc;
   private double product_price;
   private Long brandid;
   private Long vatid;
   private Long skuid;
   private Long catid;

   private String sku;
   private int stock;
   private Long attributeoptionid;

   private boolean is_featured = false;
   private boolean has_image = false;

}
