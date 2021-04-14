package tankesmedjan.webshop.repos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import tankesmedjan.webshop.dto.ProductRatingDTO;
import tankesmedjan.webshop.models.Product;
import tankesmedjan.webshop.models.ProductRating;

import java.util.List;

public interface ProductRatingRepo extends CrudRepository<ProductRating, Long> {

    List<ProductRating> findAll();


    @Query("SELECT new ProductRating (AVG(r.rating)) FROM ProductRating r " +
    "inner join Product p on p.id = r.product.id " +
    "WHERE r.product.id = ?1 ")
    List<ProductRating> getAverageRatingsByProductId(Long id);

}
