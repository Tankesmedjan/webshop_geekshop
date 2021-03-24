package hejmi.demo.repos;

import hejmi.demo.models.Products;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductsRepo extends CrudRepository<Products, Integer> {

    //@Query("SELECT distinct p from Products p inner join SKU s ON p.id = s.product.id")
    public List<Products> findAll();

    public List<Products> findAllByCategoryId(Long catid);
    public List<Products> findProductsById(Long prodid);
}

