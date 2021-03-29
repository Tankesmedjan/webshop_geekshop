package tankesmedjan.webshop.controllers;

import org.springframework.web.bind.annotation.*;
import tankesmedjan.webshop.models.Brands;
import tankesmedjan.webshop.models.Categories;
import tankesmedjan.webshop.models.Products;
import tankesmedjan.webshop.repos.BrandsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import tankesmedjan.webshop.repos.ProductsRepo;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/brands")
public class BrandsController {

    @Autowired
    private BrandsRepo brandsRepo;

    @Autowired
    private ProductsRepo productsRepo;

    @GetMapping
    public List<Brands> getAllBrands() {
        return brandsRepo.findAll();
    }

    @PostMapping
    public Brands addBrand(@RequestBody Brands brand) {
        brandsRepo.save(brand);
        return brand;
    }

    @GetMapping("/{id}")
    public List<Products> getAllProductsFomBrand(@PathVariable Long id) {
        return productsRepo.findAllByBrands_Id(id);
    }
}
