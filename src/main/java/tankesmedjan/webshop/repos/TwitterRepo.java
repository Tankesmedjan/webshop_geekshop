package tankesmedjan.webshop.repos;

import org.springframework.data.repository.CrudRepository;
import tankesmedjan.webshop.models.Hashtag;

public interface TwitterRepo extends CrudRepository<Hashtag, String> {
}
