package hejmi.demo.controllers;

import hejmi.demo.models.SKU;
import hejmi.demo.repos.SKURepo;
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
