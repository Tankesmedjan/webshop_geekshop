package hejmi.demo.repos;

import hejmi.demo.models.Categories;
import org.springframework.data.repository.CrudRepository;

public interface CategoriesRepo extends CrudRepository<Categories, Integer> {
}
