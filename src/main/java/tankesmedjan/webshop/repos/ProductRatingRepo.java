package tankesmedjan.webshop.repos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import tankesmedjan.webshop.models.ProductRating;
import tankesmedjan.webshop.models.Products;

import java.util.List;

public interface ProductRatingRepo extends CrudRepository<ProductRating, Long> {

//    @Query("SELECT p FROM Product p INNER JOIN SKU s ON p.id = s.products.id")
//    List<Products> findAll();
}
