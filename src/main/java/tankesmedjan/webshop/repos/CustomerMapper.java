package tankesmedjan.webshop.repos;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import tankesmedjan.webshop.dto.AccountAndCostumerCreationDTO;
import tankesmedjan.webshop.models.Customer;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper( CustomerMapper.class );

    @Mapping(source = "firstname", target = "firstname")
    @Mapping(source = "lastname" , target = "lastname")
    @Mapping(source = "address" , target = "address")
    @Mapping(source = "postal" , target = "postal")
    @Mapping(source = "city" , target = "city")
    @Mapping(source = "phone" , target = "phone")
    @Mapping(source = "email" , target = "email")
    Customer dtoToCustomer (AccountAndCostumerCreationDTO accountAndCostumerCreationDTO);
}
