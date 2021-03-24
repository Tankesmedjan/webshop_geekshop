package hejmi.demo.repos;

import hejmi.demo.models.SKU;
import hejmi.demo.models.Vat;
import org.springframework.data.repository.CrudRepository;

public interface SKURepo extends CrudRepository<SKU, Integer> {
}
