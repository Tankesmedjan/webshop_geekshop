package hejmi.demo.repos;

import hejmi.demo.models.Products;
import org.springframework.data.repository.CrudRepository;

public interface ProductsRepo extends CrudRepository<Products, Integer> {
}
