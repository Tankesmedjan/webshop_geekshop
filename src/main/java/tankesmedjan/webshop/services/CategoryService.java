package tankesmedjan.webshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tankesmedjan.webshop.dto.CategoryDTO;
import tankesmedjan.webshop.mappers.CategoryMapper;
import tankesmedjan.webshop.models.Category;
import tankesmedjan.webshop.models.SKU;
import tankesmedjan.webshop.repos.CategoryRepo;
import tankesmedjan.webshop.repos.ProductRepo;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepo categoryRepo;
    private final ProductRepo productRepo;

    @Autowired
    public CategoryService(CategoryRepo categoryRepo, ProductRepo productRepo) {
        this.categoryRepo = categoryRepo;
        this.productRepo = productRepo;
    }

    /**
     * Method to save a new Category to the database.
     * @param categoryDTO is the input from the user, and maps to the entity Category through mapstruct.
     * @return the input from the user.
     */
    public CategoryDTO addCategory(CategoryDTO categoryDTO) {
        Category category = CategoryMapper.INSTANCE.dtoToCategory(categoryDTO);
        categoryRepo.save(category);
        return categoryDTO;
    }

    /**
     * @return a list of all the categories in the database.
     */
    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

    /**
     * @param id is the input from the user, and represent the id of a category if it exists in the database.
     * @return the categoryId, parentCategoryId and categoryName from the id the user used as input.
     */
    public List<Category> getCategory(Long id) {
        return categoryRepo.findById(id);
    }

    /**
     * @param id is the input from the user, and represent the id of a category if it exists in the database.
     * @return a list of all the products in the category the id represents.
     */
    public List<SKU> getAllProductsByCategoryId(Long id) {
        return productRepo.findAllByCategoryId(id);
    }

}
