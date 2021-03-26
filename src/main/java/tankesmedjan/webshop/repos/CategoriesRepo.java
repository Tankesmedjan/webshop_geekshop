package tankesmedjan.webshop.repos;

import tankesmedjan.webshop.models.Categories;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoriesRepo extends CrudRepository<Categories, Integer> {
    public List<Categories> findAll();
}
