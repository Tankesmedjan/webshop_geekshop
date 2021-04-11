package tankesmedjan.webshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import tankesmedjan.webshop.dto.CategoryDTO;
import tankesmedjan.webshop.models.Category;
import tankesmedjan.webshop.models.SKU;
import tankesmedjan.webshop.services.CategoryService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public CategoryDTO addCategory(@RequestBody CategoryDTO category) {
        return categoryService.addCategory(category);
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    //  "/{id}"
    @GetMapping("/id")
    public List<SKU> getAllProductsInCategory(@Param("id") Long id) {
        return categoryService.getAllProductsByCategoryId(id);
    }

    //  "/category/{id}"
    @GetMapping("/category")
    public List<Category> getCategoryInfo(@Param("id") Long id) {
        return categoryService.getCategory(id);
    }
}
