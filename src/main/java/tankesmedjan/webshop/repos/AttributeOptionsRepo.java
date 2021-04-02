package tankesmedjan.webshop.repos;

import org.springframework.data.jpa.repository.Query;
import tankesmedjan.webshop.models.Attribute;
import tankesmedjan.webshop.models.AttributeOptions;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AttributeOptionsRepo extends CrudRepository<AttributeOptions, Integer> {
    @Query("SELECT a1, s1 from AttributeOptions a1 " +
            "inner join Attribute a2 on " +
            "a1.attribute.id = a2.id " +
            "inner join SKU s1 on " +
            "s1.attributeOptions.id = a1.id " +
            "where s1.products.id = ?1")
    List<AttributeOptions> findAllAttributesForProduct(Long id);
}
