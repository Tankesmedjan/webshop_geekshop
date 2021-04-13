package tankesmedjan.webshop.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import tankesmedjan.webshop.dto.AccountAndCostumerCreationDTO;
import tankesmedjan.webshop.models.Account;


/**
 * Mapper with MapStruct
 * https://mapstruct.org/documentation/reference-guide/
 *
 * Maps the dto:information to entities
 */

@Mapper
public interface AccountMapper {

    AccountMapper INSTANCE = Mappers.getMapper( AccountMapper.class );

    @Mapping(source = "username", target = "username")
    @Mapping(source = "password" , target = "password")
    @Mapping(source = "role" , target = "role")
    Account dtoToAccount (AccountAndCostumerCreationDTO accountAndCostumerCreationDTO);
}
