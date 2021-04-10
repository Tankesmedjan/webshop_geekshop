package tankesmedjan.webshop.controllers;

import org.springframework.web.bind.annotation.*;
import tankesmedjan.webshop.models.SKU;
import tankesmedjan.webshop.services.BrandService;
import tankesmedjan.webshop.models.Brand;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/brands")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping
    public List<Brand> getAllBrands() {
        return brandService.findAll();
    }

    @PostMapping
    public Brand addBrand(@RequestBody Brand brand) {
        return brandService.saveBrand(brand);
    }

    @GetMapping("/{id}")
    public List<SKU> getAllProductsFromBrand(@PathVariable Long id) {
        return brandService.getProductsByBrandId(id);
    }

    @GetMapping("/brand/{id}")
    public List<Brand> getBrand(@PathVariable Long id) {
        return brandService.getBrand(id);
    }
}
