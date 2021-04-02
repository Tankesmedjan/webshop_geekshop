package tankesmedjan.webshop.controllers;

import org.hibernate.annotations.GeneratorType;
import org.springframework.web.bind.annotation.*;
import tankesmedjan.webshop.dto.AddAttributeDTO;
import tankesmedjan.webshop.dto.AddAttributeOptionDTO;
import tankesmedjan.webshop.models.Attribute;
import tankesmedjan.webshop.models.AttributeOptions;
import tankesmedjan.webshop.services.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/attributes")
public class AttributeController {

    @Autowired
    private AttributeService attributeService;

    @PostMapping
    public AddAttributeDTO addAttribute(@RequestBody AddAttributeDTO attribute) {
        attributeService.saveAttribute(attribute);
        return attribute;
    }
    @PostMapping("/option")
    public AddAttributeOptionDTO addAttributeOption(@RequestBody AddAttributeOptionDTO addAttributeOptionDTO) {
        attributeService.addAttributeOption(addAttributeOptionDTO);
        return addAttributeOptionDTO;
    }

    @GetMapping("/product/{id}")
    public List<AttributeOptions> getAttributesListForProductId(@PathVariable Long id) {
        return attributeService.getAttributesListForProductId(id);
    }

}
