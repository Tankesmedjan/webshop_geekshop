package tankesmedjan.webshop.repos;

import tankesmedjan.webshop.models.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepo extends CrudRepository<Category, Integer> {
    public List<Category> findAll();
    public List<Category> findById(Long id);
}
