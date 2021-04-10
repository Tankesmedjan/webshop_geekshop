package tankesmedjan.webshop.repos;

import org.springframework.data.repository.CrudRepository;
import tankesmedjan.webshop.models.ProductRating;

public interface ProductRatingRepo extends CrudRepository<ProductRating, Long> {

//    @Query("SELECT p FROM Product p INNER JOIN SKU s ON p.id = s.products.id")
//    List<Product> findAll();
}
