package tankesmedjan.webshop.controllers;

import tankesmedjan.webshop.Service.CategoryService;
import tankesmedjan.webshop.Service.ProductService;
import tankesmedjan.webshop.models.Categories;
import tankesmedjan.webshop.models.Products;
import tankesmedjan.webshop.repos.CategoriesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tankesmedjan.webshop.repos.ProductsRepo;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/categories")
public class CategoriesController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public Categories addCategory(@RequestBody Categories category) {
        categoryService.addCategory(category);
        return category;
    }

    @GetMapping
    public List<Categories> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public List<Products> getAllProductsInCategory(@PathVariable Long id) {
        return categoryService.getAllProductsByCategoryId(id);
    }
}
