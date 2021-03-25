package hejmi.demo.repos;

import hejmi.demo.models.Products;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductsRepo extends CrudRepository<Products, Integer> {

    @Query("SELECT p FROM Products p " +
            "INNER JOIN Categories c ON c.id = p.category.id"
    )
    public List<Products> findAll();

    public List<Products> findAllByCategoryId(Long catid);
    public List<Products> findProductsById(Long prodid);
}

