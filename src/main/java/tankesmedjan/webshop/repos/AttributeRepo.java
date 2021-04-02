package tankesmedjan.webshop.repos;

import org.springframework.data.jpa.repository.Query;
import tankesmedjan.webshop.models.Attribute;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AttributeRepo extends CrudRepository<Attribute, Integer> {

}
