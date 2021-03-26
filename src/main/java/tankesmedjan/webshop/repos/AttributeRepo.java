package tankesmedjan.webshop.repos;

import tankesmedjan.webshop.models.Attribute;
import org.springframework.data.repository.CrudRepository;

public interface AttributeRepo extends CrudRepository<Attribute, Integer> {
}