package tankesmedjan.webshop.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import tankesmedjan.webshop.dto.AccountAndCostumerCreationDTO;
import tankesmedjan.webshop.dto.SkuDTO;
import tankesmedjan.webshop.models.Customer;
import tankesmedjan.webshop.models.SKU;

@Mapper
public interface SkuMapper {

    SkuMapper INSTANCE = Mappers.getMapper( SkuMapper.class );

    @Mapping(source = "sku", target = "sku")
    @Mapping(source = "stock" , target = "stock")
    @Mapping(source = "price_diff" , target = "priceDiff")
    @Mapping(source = "attributeOptionId" , target = "attributeOption.id")
    @Mapping(source = "productId" , target = "product.id")
    SKU dtoToSku (SkuDTO skuDTO);
}
