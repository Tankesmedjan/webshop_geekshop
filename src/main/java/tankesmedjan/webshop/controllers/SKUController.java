package tankesmedjan.webshop.controllers;

import org.springframework.web.bind.annotation.*;
import tankesmedjan.webshop.services.SKUService;
import tankesmedjan.webshop.models.SKU;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/sku")
public class SKUController {

    @Autowired
    private SKUService skuService;

    @PostMapping
    public SKU addSKU(@RequestBody SKU sku) {
        skuService.addSKU(sku);
        return sku;
    }
}
