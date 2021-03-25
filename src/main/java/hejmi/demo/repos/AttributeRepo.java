package hejmi.demo.repos;

import hejmi.demo.models.Attribute;
import org.springframework.data.repository.CrudRepository;

public interface AttributeRepo extends CrudRepository<Attribute, Integer> {
}