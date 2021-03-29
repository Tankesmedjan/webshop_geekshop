package tankesmedjan.webshop.controllers;

import tankesmedjan.webshop.models.Products;
import tankesmedjan.webshop.repos.ProductsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/products")
public class ProductsController {

    @Autowired
    private ProductsRepo productsRepo;

    @PostMapping
    public Products addProduct(@RequestBody Products product ) {
        productsRepo.save(product);
        return product;
    }

    @GetMapping
    public List<Products> getAllProducts() {
        return productsRepo.findAll();
    }

    @GetMapping("/featured")
    public List<Products> getAllFeaturedProducts() {
        return productsRepo.findAllByIs_featured();
    }

    @GetMapping("/{id}")
    public List<Products> getProductById(@PathVariable Long id) {
        return productsRepo.findProductsById(id);
    }
}
