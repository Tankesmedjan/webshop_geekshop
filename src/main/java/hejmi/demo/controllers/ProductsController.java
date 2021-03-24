package hejmi.demo.controllers;

import hejmi.demo.models.Products;
import hejmi.demo.repos.ProductsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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

    @GetMapping("/{id}")
    public List<Products> getProductById(@PathVariable Long id) {
        return productsRepo.findProductsById(id);
    }
}
