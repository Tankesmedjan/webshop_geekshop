package hejmi.demo.repos;

import hejmi.demo.models.Brands;
import hejmi.demo.models.Vat;
import org.springframework.data.repository.CrudRepository;

public interface VatRepo extends CrudRepository<Vat, Integer> {
}
