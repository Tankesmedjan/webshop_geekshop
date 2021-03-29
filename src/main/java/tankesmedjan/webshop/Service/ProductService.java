package tankesmedjan.webshop.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tankesmedjan.webshop.models.Products;
import tankesmedjan.webshop.repos.ProductsRepo;

@Component
public class ProductService {

    private ProductsRepo productsRepo;

@Autowired
    public ProductService(ProductsRepo productsRepo){

        this.productsRepo = productsRepo;
    }

    public Products addProduct(Products products){
    productsRepo.save(products);
    return products;
    }

}
