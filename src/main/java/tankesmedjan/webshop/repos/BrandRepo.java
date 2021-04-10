package tankesmedjan.webshop.repos;

import tankesmedjan.webshop.models.Brand;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BrandRepo extends CrudRepository<Brand, Integer> {
    public List<Brand> findAll();
    public List<Brand> findById(Long id);
}
