package tankesmedjan.webshop.controllers;

import tankesmedjan.webshop.models.Categories;
import tankesmedjan.webshop.models.Products;
import tankesmedjan.webshop.repos.CategoriesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tankesmedjan.webshop.repos.ProductsRepo;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {

    @Autowired
    private CategoriesRepo categoriesRepo;

    @Autowired
    private ProductsRepo productsRepo;

    @PostMapping
    public Categories addCategory(@RequestBody Categories category) {
        categoriesRepo.save(category);
        return category;
    }

    @GetMapping
    public List<Categories> getAllCategories() {
        return categoriesRepo.findAll();
    }

    @GetMapping("/{id}")
    public List<Products> getAllProductsInCategory(@PathVariable Long id) {
        return productsRepo.findAllByCategoryId(id);
    }
}
