package tankesmedjan.webshop.repos;

import org.springframework.data.repository.query.Param;
import tankesmedjan.webshop.models.Products;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import tankesmedjan.webshop.models.SKU;

import java.util.List;

public interface ProductsRepo extends CrudRepository<Products, Long> {

    @Query("SELECT p FROM Products p INNER JOIN SKU s ON p.id = s.products.id")
    List<Products> findAll();

    @Query("SELECT s, p.id FROM SKU s " +
            "inner join Products p on p.id = s.products.id " +
            "WHERE p.is_featured = true " +
            "GROUP BY p.id")
    List<SKU> findAllIsfeatured();

    @Query("SELECT s, p.id FROM SKU s " +
            "inner join Products p on p.id = s.products.id " +
            "where p.category.id = ?1 " +
            "GROUP BY p.id")
    List<SKU> findAllByCategoryId(Long id);

    @Query("SELECT s, p.id FROM SKU s " +
            "inner join Products p on p.id = s.products.id " +
            "where p.brands.id = ?1 " +
            "GROUP BY p.id")
    List<SKU> findAllByBrands_Id(Long id);

    @Query("SELECT s, p FROM SKU s " +
            "inner join Products p on p.id = s.products.id " +
            "where p.id = ?1 " +
            "group by p.id")
    List<SKU> findProductsById(Long id);

    @Query("SELECT s, p.id FROM SKU s " +
            "INNER JOIN Products p ON s.products.id = p.id " // updated for new SKU relation in db, returns all available product options
            + "WHERE p.product_name LIKE %?1%"
            + " OR p.brands.brand_name LIKE %?1%"
            + " OR p.category.category_name LIKE %?1%"
            + " GROUP BY p.id")
    List<SKU> searchProduct(String keyword);

    @Query("SELECT p FROM Products p WHERE p.id =?1")
    Products findSingleProductById(Long id);
}

