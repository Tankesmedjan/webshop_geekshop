package tankesmedjan.webshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tankesmedjan.webshop.dto.AddCategoryDTO;
import tankesmedjan.webshop.models.Categories;
import tankesmedjan.webshop.models.Products;
import tankesmedjan.webshop.repos.CategoriesRepo;
import tankesmedjan.webshop.repos.ProductsRepo;

import java.util.List;

@Service
public class CategoryService {

    private CategoriesRepo categoriesRepo;
    private ProductsRepo productsRepo;

    @Autowired
    public CategoryService(CategoriesRepo categoriesRepo, ProductsRepo productsRepo) {
        this.categoriesRepo = categoriesRepo;
        this.productsRepo = productsRepo;
    }

    public AddCategoryDTO addCategory(AddCategoryDTO addCategoryDTO) {
        Categories addNewCategory = new Categories(addCategoryDTO);
        categoriesRepo.save(addNewCategory);
        return addCategoryDTO;
    }

    public List<Categories> getAllCategories() {
        return categoriesRepo.findAll();
    }

    public List<Categories> getCategory(Long id) {
        return categoriesRepo.findById(id);
    }

    public List<Products> getAllProductsByCategoryId(Long id) {
        return productsRepo.findAllByCategoryId(id);
    }

}
