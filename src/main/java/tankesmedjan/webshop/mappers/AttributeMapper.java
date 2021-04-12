package tankesmedjan.webshop.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import tankesmedjan.webshop.dto.AttributeDTO;
import tankesmedjan.webshop.models.Attribute;

@Mapper
public interface AttributeMapper {

    AttributeMapper INSTANCE = Mappers.getMapper( AttributeMapper.class);

    @Mapping(source = "attribute_name", target = "attributeName")
    Attribute DtoToAttribute(AttributeDTO attributeDTO);
}
