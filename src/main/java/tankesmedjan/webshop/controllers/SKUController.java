package tankesmedjan.webshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import tankesmedjan.webshop.models.SKU;
import tankesmedjan.webshop.services.SKUService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/sku")
public class SKUController {

    private final SKUService skuService;

    @Autowired
    public SKUController(SKUService skuService){
        this.skuService = skuService;
    }

    @GetMapping
    public List<SKU> getAllSKU() {
        return skuService.getAllSku();
    }

    @GetMapping("/product")
    public List<SKU> getSKUSByProductId(@Param("id") Long id) {
        return skuService.getSKUsByProductId(id);
    }

    @GetMapping("/sku")
    public List<SKU> getSKUById(@Param("sku") String sku) {
        return skuService.getSKUProduct(sku);
    }

    @GetMapping("/id")
    public List<SKU> getSKUBySkuId(@Param("id") Long id) {
        return skuService.getSKUById(id);
    }
}
