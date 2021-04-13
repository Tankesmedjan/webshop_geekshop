package tankesmedjan.webshop.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import tankesmedjan.webshop.dto.BrandDTO;
import tankesmedjan.webshop.models.Brand;


@Mapper
public interface BrandMapper {
    /**
     * BrandMapper maps the BrandDTO to the brand entity.
     */
    BrandMapper INSTANCE = Mappers.getMapper( BrandMapper.class );

    @Mapping(source = "brandName", target = "brandName")
    @Mapping(source = "brandLogo" , target = "brandLogo")
    Brand dtoToBrand (BrandDTO brandDTO);
}
