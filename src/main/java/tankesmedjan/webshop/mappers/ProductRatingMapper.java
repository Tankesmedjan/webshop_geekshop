package tankesmedjan.webshop.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import tankesmedjan.webshop.dto.ProductRatingDTO;
import tankesmedjan.webshop.models.ProductRating;

/**
 * Mapper with MapStruct
 * https://mapstruct.org/documentation/reference-guide/
 *
 * Maps the dto:information to entities
 */

@Mapper
public interface ProductRatingMapper {

    ProductRatingMapper INSTANCE = Mappers.getMapper( ProductRatingMapper.class );

    @Mapping(source = "rating", target = "rating")
    @Mapping(source = "ratingMessage", target = "ratingMessage")
    @Mapping(source = "customerId", target = "customer.id")
    @Mapping(source = "productId", target = "product.id")
    ProductRating dtoToProductRating (ProductRatingDTO productRatingDTO);
}
