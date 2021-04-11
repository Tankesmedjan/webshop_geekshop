package tankesmedjan.webshop.repos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import tankesmedjan.webshop.models.AttributeOption;
import tankesmedjan.webshop.models.SKU;

import java.util.List;

public interface AttributeOptionRepo extends CrudRepository<AttributeOption, Integer> {
    @Query("SELECT s1, a1 from SKU s1 " +
            "inner join AttributeOption a1 on " +
            "s1.attributeOption.id = a1.id " +
            "inner join Attribute a2 on " +
            "a2.id = a1.attribute.id " +
            "where s1.product.id = ?1")
    List<SKU> findAllAttributesForProduct(Long id);
}
