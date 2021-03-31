package tankesmedjan.webshop.controllers;

import org.springframework.web.bind.annotation.*;
import tankesmedjan.webshop.dto.AddAttributeDTO;
import tankesmedjan.webshop.dto.AddAttributeOptionDTO;
import tankesmedjan.webshop.services.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;

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

}
