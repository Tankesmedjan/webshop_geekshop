package hejmi.demo.repos;

import hejmi.demo.models.Attribute;
import hejmi.demo.models.Vat;
import org.springframework.data.repository.CrudRepository;

public interface AttributeRepo extends CrudRepository<Attribute, Integer> {
}
