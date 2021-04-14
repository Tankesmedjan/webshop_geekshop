package tankesmedjan.webshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import tankesmedjan.webshop.dto.AttributeDTO;
import tankesmedjan.webshop.dto.AttributeOptionDTO;
import tankesmedjan.webshop.models.SKU;
import tankesmedjan.webshop.services.AttributeService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/attributes")
public class AttributeController {

    private final AttributeService attributeService;

    @Autowired
    public AttributeController(AttributeService attributeService){
        this.attributeService = attributeService;
    }

    @PostMapping
    public AttributeDTO addAttribute(@RequestBody AttributeDTO attribute) {
        attributeService.saveAttribute(attribute);
        return attribute;
    }
    @PostMapping("/option")
    public AttributeOptionDTO addAttributeOption(@RequestBody AttributeOptionDTO attributeOptionDTO) {
        attributeService.addAttributeOption(attributeOptionDTO);
        return attributeOptionDTO;
    }

    @GetMapping("/product")
    public List<SKU> getAttributesListForProductId(@Param("id") Long id) {
        return attributeService.getAttributesListForProductId(id);
    }

}
