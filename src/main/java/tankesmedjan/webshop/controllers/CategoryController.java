package tankesmedjan.webshop.controllers;

import tankesmedjan.webshop.dto.AddCategoryDTO;
import tankesmedjan.webshop.models.SKU;
import tankesmedjan.webshop.services.CategoryService;
import tankesmedjan.webshop.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public AddCategoryDTO addCategory(@RequestBody AddCategoryDTO category) {
        return categoryService.addCategory(category);
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public List<SKU> getAllProductsInCategory(@PathVariable Long id) {
        return categoryService.getAllProductsByCategoryId(id);
    }
    @GetMapping("/category/{id}")
    public List<Category> getCategoryInfo(@PathVariable Long id) {
        return categoryService.getCategory(id);
    }
}
