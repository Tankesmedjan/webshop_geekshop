package hejmi.demo.repos;

import hejmi.demo.models.Brands;
import org.springframework.data.repository.CrudRepository;

public interface BrandsRepo extends CrudRepository<Brands, Integer> {
}
