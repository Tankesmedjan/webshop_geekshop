package tankesmedjan.webshop.controllers;

import tankesmedjan.webshop.models.Categories;
import tankesmedjan.webshop.repos.CategoriesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {

    @Autowired
    private CategoriesRepo categoriesRepo;

    @PostMapping
    public Categories addCategory(@RequestBody Categories category) {
        categoriesRepo.save(category);
        return category;
    }

    @GetMapping
    public List<Categories> getAllCategories() {
        return categoriesRepo.findAll();
    }
}
