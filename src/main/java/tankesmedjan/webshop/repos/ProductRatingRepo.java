package tankesmedjan.webshop.repos;

import org.springframework.data.repository.CrudRepository;
import tankesmedjan.webshop.models.ProductRating;

public interface ProductRatingRepo extends CrudRepository<ProductRating, Long> {
}
