package tankesmedjan.webshop.repos;

import org.springframework.data.jpa.repository.Query;
import tankesmedjan.webshop.models.Attribute;
import tankesmedjan.webshop.models.AttributeOptions;
import org.springframework.data.repository.CrudRepository;
import tankesmedjan.webshop.models.SKU;

import java.util.List;

public interface AttributeOptionsRepo extends CrudRepository<AttributeOptions, Integer> {
    /* @Query("SELECT a1, s1 from AttributeOptions a1 " +
            "inner join Attribute a2 on " +
            "a1.attribute.id = a2.id " +
            "inner join SKU s1 on " +
            "s1.attributeOptions.id = a1.id " +
            "where s1.products.id = ?1")
    List<SKU> findAllAttributesForProduct(Long id); */
    @Query("SELECT s1, a1 from SKU s1 " +
            "inner join AttributeOptions a1 on " +
            "s1.attributeOptions.id = a1.id " +
            "inner join Attribute a2 on " +
            "a2.id = a1.attribute.id " +
            "where s1.products.id = ?1")
    List<SKU> findAllAttributesForProduct(Long id);
}
