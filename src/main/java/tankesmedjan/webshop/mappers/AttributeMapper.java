package tankesmedjan.webshop.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import tankesmedjan.webshop.dto.AttributeDTO;
import tankesmedjan.webshop.models.Attribute;

/**
 * Mapper with MapStruct
 * https://mapstruct.org/documentation/reference-guide/
 *
 * Maps the dto:information to entities
 */

@Mapper
public interface AttributeMapper {

    AttributeMapper INSTANCE = Mappers.getMapper( AttributeMapper.class);

    @Mapping(source = "attribute_name", target = "attributeName")
    Attribute DtoToAttribute(AttributeDTO attributeDTO);
}
