package tankesmedjan.webshop.controllers;

import org.springframework.web.bind.annotation.*;
import tankesmedjan.webshop.services.AttributeService;
import tankesmedjan.webshop.models.Attribute;
import tankesmedjan.webshop.models.AttributeOptions;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/attributes")
public class AttributeController {

    @Autowired
    private AttributeService attributeService;

    @PostMapping
    public Attribute addAttribute(@RequestBody Attribute attribute) {
        attributeService.saveAttribute(attribute);
        return attribute;
    }
    @PostMapping("/option")
    public AttributeOptions addAttributeOption(@RequestBody AttributeOptions attributeOption) {
        attributeService.addAttributeOption(attributeOption);
        return attributeOption;
    }

}
