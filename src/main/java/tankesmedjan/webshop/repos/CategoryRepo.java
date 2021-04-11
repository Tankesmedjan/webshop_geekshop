package tankesmedjan.webshop.repos;

import org.springframework.data.repository.CrudRepository;
import tankesmedjan.webshop.models.Category;

import java.util.List;

public interface CategoryRepo extends CrudRepository<Category, Integer> {
    public List<Category> findAll();
    public List<Category> findById(Long id);
}
