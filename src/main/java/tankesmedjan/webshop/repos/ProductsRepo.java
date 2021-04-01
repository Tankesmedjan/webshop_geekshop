package tankesmedjan.webshop.repos;

import tankesmedjan.webshop.models.Products;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductsRepo extends CrudRepository<Products, Integer> {

    @Query("SELECT p FROM Products p INNER JOIN SKU s ON p.id = s.products.id")
    public List<Products> findAll();

    @Query("SELECT p FROM Products p WHERE p.is_featured = true")
    public List<Products> findAllByIs_featured();
    
    public List<Products> findAllByCategoryId(Long id);

    public List<Products> findAllByBrands_Id(Long id);
    public List<Products> findProductsById(Long id);

    @Query("SELECT p FROM Products p " +
            "INNER JOIN SKU s ON s.products.id = p.id " // updated for new SKU relation in db, returns all available product options
            + "WHERE p.product_name LIKE %?1%"
            + " OR p.brands.brand_name LIKE %?1%"
            + " OR p.category.category_name LIKE %?1%")
    public List<Products> searchProduct(String keyword);
}

