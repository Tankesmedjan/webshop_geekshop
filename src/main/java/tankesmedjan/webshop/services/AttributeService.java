package tankesmedjan.webshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tankesmedjan.webshop.dto.AddAttributeDTO;
import tankesmedjan.webshop.dto.AddAttributeOptionDTO;
import tankesmedjan.webshop.models.Attribute;
import tankesmedjan.webshop.models.AttributeOption;
import tankesmedjan.webshop.models.SKU;
import tankesmedjan.webshop.repos.AttributeOptionRepo;
import tankesmedjan.webshop.repos.AttributeRepo;

import java.util.List;

@Service
public class AttributeService {

    @Autowired
    private AttributeRepo attributeRepo;

    @Autowired
    private AttributeOptionRepo attributeOptionRepo;

    public AddAttributeDTO saveAttribute(AddAttributeDTO addAttributeDTO) {
        Attribute addNewAttribute = new Attribute(addAttributeDTO);
        attributeRepo.save(addNewAttribute);
        return addAttributeDTO;
    }

    public AddAttributeOptionDTO addAttributeOption(AddAttributeOptionDTO attributeOptionDTO) {
        AttributeOption addNewAttributeOption = new AttributeOption(attributeOptionDTO);
        attributeOptionRepo.save(addNewAttributeOption);
        return attributeOptionDTO;
    }

    public List<SKU> getAttributesListForProductId(Long id) {
        return attributeOptionRepo.findAllAttributesForProduct(id);
    }
}
