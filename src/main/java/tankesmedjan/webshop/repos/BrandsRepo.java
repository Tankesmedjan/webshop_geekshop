package tankesmedjan.webshop.repos;

import tankesmedjan.webshop.models.Brands;
import org.springframework.data.repository.CrudRepository;
import tankesmedjan.webshop.models.Categories;

import java.util.List;

public interface BrandsRepo extends CrudRepository<Brands, Integer> {
    public List<Brands> findAll();
    public List<Brands> findById(Long id);
}
