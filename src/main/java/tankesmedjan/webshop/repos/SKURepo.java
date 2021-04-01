package tankesmedjan.webshop.repos;

import org.springframework.data.jpa.repository.Query;
import tankesmedjan.webshop.models.Products;
import tankesmedjan.webshop.models.SKU;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SKURepo extends CrudRepository<SKU, Integer> {

    List<SKU> findAll();
    List<SKU> findSKUSByProductsId(Long id);
    List<SKU> findBySku(String sku);
    List<SKU> findById(Long id);
}
