package tankesmedjan.webshop.controllers;

import org.springframework.web.bind.annotation.*;
import tankesmedjan.webshop.services.SKUService;
import tankesmedjan.webshop.models.SKU;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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

    @GetMapping
    public List<SKU> getAllSKU() {
        return skuService.getAllSku();
    }

    @GetMapping("/product/{id}")
    public List<SKU> getSKUSByProductId(@PathVariable Long id) {
        return skuService.getSKUsByProductId(id);
    }

    @GetMapping("/{sku}")
    public List<SKU> getSKUById(@PathVariable String sku) {
        return skuService.getSKUProduct(sku);
    }

    @GetMapping("/id/{id}")
    public List<SKU> getSKUBySkuId(@PathVariable Long id) {
        return skuService.getSKUById(id);
    }
}
