package tankesmedjan.webshop.repos;

import org.springframework.data.repository.CrudRepository;
import tankesmedjan.webshop.models.Brand;

import java.util.List;

public interface BrandRepo extends CrudRepository<Brand, Integer> {
    public List<Brand> findAll();
    public List<Brand> findById(Long id);
}
