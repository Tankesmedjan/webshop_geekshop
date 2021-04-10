package tankesmedjan.webshop.repos;

import tankesmedjan.webshop.models.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import tankesmedjan.webshop.models.SKU;

import java.util.List;

public interface ProductRepo extends CrudRepository<Product, Long> {

    @Query("SELECT p FROM Product p INNER JOIN SKU s ON p.id = s.product.id GROUP BY p.id")
    List<Product> findAll();

    @Query("SELECT s, p.id FROM SKU s " +
            "inner join Product p on p.id = s.product.id " +
            "WHERE p.isFeatured = true " +
            "GROUP BY p.id")
    List<SKU> findAllIsfeatured();

    @Query("SELECT s, p.id FROM SKU s " +
            "inner join Product p on p.id = s.product.id " +
            "where p.category.id = ?1 " +
            "GROUP BY p.id")
    List<SKU> findAllByCategoryId(Long id);

    @Query("SELECT s, p.id FROM SKU s " +
            "inner join Product p on p.id = s.product.id " +
            "where p.brand.id = ?1 " +
            "GROUP BY p.id")
    List<SKU> findAllByBrands_Id(Long id);

    @Query("SELECT s, p FROM SKU s " +
            "inner join Product p on p.id = s.product.id " +
            "where p.id = ?1 " +
            "group by p.id")
    List<SKU> findProductsById(Long id);

    @Query("SELECT s, p.id FROM SKU s " +
            "INNER JOIN Product p ON s.product.id = p.id " // updated for new SKU relation in db, returns all available product options
            + "WHERE p.productName LIKE %?1%"
            + " OR p.brand.brandName LIKE %?1%"
            + " OR p.category.categoryName LIKE %?1%"
            + " GROUP BY p.id")
    List<SKU> searchProduct(String keyword);

    @Query("SELECT p FROM Product p WHERE p.id =?1")
    Product findSingleProductById(Long id);
}

