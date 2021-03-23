package hejmi.demo.controllers;

import hejmi.demo.models.Products;
import hejmi.demo.repos.CategoriesRepo;
import hejmi.demo.repos.ProductsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductsRepo productsRepo;
    @Autowired
    private CategoriesRepo categoriesRepo;

    @PostMapping
    public Products addProduct(@RequestBody Products product ) {
        productsRepo.save(product);
        return product;
    }
}
