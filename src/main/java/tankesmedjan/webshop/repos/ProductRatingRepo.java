package tankesmedjan.webshop.repos;

import org.springframework.data.repository.CrudRepository;
import tankesmedjan.webshop.models.ProductRating;

import java.util.List;

public interface ProductRatingRepo extends CrudRepository<ProductRating, Long> {

    List<ProductRating> findAll();
    List<ProductRating> findByRating(int rating);
}
