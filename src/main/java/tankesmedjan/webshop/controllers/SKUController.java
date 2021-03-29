package tankesmedjan.webshop.controllers;

import org.springframework.web.bind.annotation.*;
import tankesmedjan.webshop.models.SKU;
import tankesmedjan.webshop.repos.SKURepo;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/sku")
public class SKUController {

    @Autowired
    private SKURepo skuRepo;

    @PostMapping
    public SKU addSKU(@RequestBody SKU sku) {
        skuRepo.save(sku);
        return sku;
    }
}
