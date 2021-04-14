package tankesmedjan.webshop.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import tankesmedjan.webshop.dto.AttributeOptionDTO;
import tankesmedjan.webshop.models.Attribute;
import tankesmedjan.webshop.models.AttributeOption;

/**
 * Mapper with MapStruct
 * https://mapstruct.org/documentation/reference-guide/
 *
 * Maps the dto:information to entities
 */

@Mapper
public interface AttributeOptionMapper {

    AttributeOptionMapper INSTANCE = Mappers.getMapper( AttributeOptionMapper.class);

    @Mapping(source = "attributeOptionName", target = "attributeOptionName")
    @Mapping(source = "attribute", target = "attribute.id")
    AttributeOption DtoToAttributeOption(AttributeOptionDTO attributeOptionDTO);

}
