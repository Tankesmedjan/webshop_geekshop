package tankesmedjan.webshop.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tankesmedjan.webshop.models.Attribute;
import tankesmedjan.webshop.models.AttributeOptions;
import tankesmedjan.webshop.repos.AttributeOptionsRepo;
import tankesmedjan.webshop.repos.AttributeRepo;

@Service
public class AttributeService {

    @Autowired
    private AttributeRepo attributeRepo;

    @Autowired
    private AttributeOptionsRepo attributeOptionsRepo;

    public Attribute saveAttribute(Attribute attribute) {
        attributeRepo.save(attribute);
        return attribute;
    }

    public AttributeOptions addAttributeOption(AttributeOptions attributeOptions) {
        attributeOptionsRepo.save(attributeOptions);
        return attributeOptions;
    }
}
