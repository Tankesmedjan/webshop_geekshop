package tankesmedjan.webshop.controllers;

import org.springframework.web.bind.annotation.*;
import tankesmedjan.webshop.Service.BrandsService;
import tankesmedjan.webshop.models.Brands;
import tankesmedjan.webshop.models.Products;
import org.springframework.beans.factory.annotation.Autowired;
import tankesmedjan.webshop.repos.ProductsRepo;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/brands")
public class BrandsController {

    @Autowired
    private BrandsService brandsService;

    @GetMapping
    public List<Brands> getAllBrands() {
        return brandsService.findAll();
    }

    @PostMapping
    public Brands addBrand(@RequestBody Brands brand) {
        brandsService.saveBrand(brand);
        return brand;
    }

    @GetMapping("/{id}")
    public List<Products> getAllProductsFromBrand(@PathVariable Long id) {
        return brandsService.getProductsByBrandId(id);
    }
}
