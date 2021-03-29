package tankesmedjan.webshop.repos;

import org.springframework.data.repository.CrudRepository;
import tankesmedjan.webshop.models.Hashtags;

public interface TwitterRepository extends CrudRepository<Hashtags, String> {
}
