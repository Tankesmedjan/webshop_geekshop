package tankesmedjan.webshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tankesmedjan.webshop.dto.AddAttributeDTO;
import tankesmedjan.webshop.dto.AddAttributeOptionDTO;
import tankesmedjan.webshop.models.Attribute;
import tankesmedjan.webshop.models.AttributeOptions;
import tankesmedjan.webshop.models.SKU;
import tankesmedjan.webshop.repos.AttributeOptionsRepo;
import tankesmedjan.webshop.repos.AttributeRepo;

import java.util.List;

@Service
public class AttributeService {

    @Autowired
    private AttributeRepo attributeRepo;

    @Autowired
    private AttributeOptionsRepo attributeOptionsRepo;

    public AddAttributeDTO saveAttribute(AddAttributeDTO addAttributeDTO) {
        Attribute addNewAttribute = new Attribute(addAttributeDTO);
        attributeRepo.save(addNewAttribute);
        return addAttributeDTO;
    }

    public AddAttributeOptionDTO addAttributeOption(AddAttributeOptionDTO attributeOptionDTO) {
        AttributeOptions addNewAttributeOption = new AttributeOptions(attributeOptionDTO);
        attributeOptionsRepo.save(addNewAttributeOption);
        return attributeOptionDTO;
    }

    public List<SKU> getAttributesListForProductId(Long id) {
        return attributeOptionsRepo.findAllAttributesForProduct(id);
    }
}
