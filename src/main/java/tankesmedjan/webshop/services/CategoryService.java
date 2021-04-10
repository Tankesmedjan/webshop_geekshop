package tankesmedjan.webshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tankesmedjan.webshop.dto.AddCategoryDTO;
import tankesmedjan.webshop.models.Category;
import tankesmedjan.webshop.models.SKU;
import tankesmedjan.webshop.repos.CategoryRepo;
import tankesmedjan.webshop.repos.ProductRepo;

import java.util.List;

@Service
public class CategoryService {

    private CategoryRepo categoryRepo;
    private ProductRepo productRepo;

    @Autowired
    public CategoryService(CategoryRepo categoryRepo, ProductRepo productRepo) {
        this.categoryRepo = categoryRepo;
        this.productRepo = productRepo;
    }

    public AddCategoryDTO addCategory(AddCategoryDTO addCategoryDTO) {
        Category addNewCategory = new Category(addCategoryDTO);
        categoryRepo.save(addNewCategory);
        return addCategoryDTO;
    }

    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

    public List<Category> getCategory(Long id) {
        return categoryRepo.findById(id);
    }

    public List<SKU> getAllProductsByCategoryId(Long id) {
        return productRepo.findAllByCategoryId(id);
    }

}
