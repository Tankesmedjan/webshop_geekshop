package tankesmedjan.webshop.controllers;

import tankesmedjan.webshop.models.SKU;
import tankesmedjan.webshop.repos.SKURepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
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
