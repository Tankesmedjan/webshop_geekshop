package tankesmedjan.webshop.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import tankesmedjan.webshop.dto.ProductDTO;
import tankesmedjan.webshop.models.*;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(source = "productName", target = "productName")
    @Mapping(source = "productPrice", target = "productPrice")
    @Mapping(source = "shortDesc", target = "shortDesc")
    @Mapping(source = "fullDesc", target = "fullDesc")
    @Mapping(source = "featured", target = "isFeatured")
    @Mapping(source = "hasImage", target = "hasImage")
    @Mapping(source = "productId", target = "id")
    @Mapping(source = "catId", target = "category.id")
    @Mapping(source = "vatId", target = "vat.id")
    @Mapping(source = "brandId", target = "brand.id")
    Product productDTOtoProduct(ProductDTO productDTO);

}
