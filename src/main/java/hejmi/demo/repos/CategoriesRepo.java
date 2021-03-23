package hejmi.demo.repos;

import hejmi.demo.models.Categories;
import hejmi.demo.models.Products;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface CategoriesRepo extends CrudRepository<Categories, Integer> {
}
