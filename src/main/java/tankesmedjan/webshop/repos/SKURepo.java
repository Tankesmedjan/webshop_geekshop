package tankesmedjan.webshop.repos;

import org.springframework.data.repository.CrudRepository;
import tankesmedjan.webshop.models.SKU;

import java.util.List;

public interface SKURepo extends CrudRepository<SKU, Long> {

    List<SKU> findAll();
    List<SKU> findSKUSByProductId(Long id);
    List<SKU> findBySku(String sku);
    List<SKU> findSKUById(Long id);
}
