package tankesmedjan.webshop.controllers;

import tankesmedjan.webshop.models.Attribute;
import tankesmedjan.webshop.models.AttributeOptions;
import tankesmedjan.webshop.repos.AttributeOptionsRepo;
import tankesmedjan.webshop.repos.AttributeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/attributes")
public class AttributeController {

    @Autowired
    private AttributeRepo attributeRepo;

    @Autowired
    private AttributeOptionsRepo attributeOptionsRepo;

    @PostMapping
    public Attribute addAttribute(@RequestBody Attribute attribute) {
        attributeRepo.save(attribute);
        return attribute;
    }
    @PostMapping("/option")
    public AttributeOptions addAttributeOption(@RequestBody AttributeOptions attributeOption) {
        attributeOptionsRepo.save(attributeOption);
        return attributeOption;
    }

}
