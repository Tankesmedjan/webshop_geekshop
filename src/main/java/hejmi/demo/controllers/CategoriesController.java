package hejmi.demo.controllers;

import hejmi.demo.models.Categories;
import hejmi.demo.repos.CategoriesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
