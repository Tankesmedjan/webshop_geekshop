package tankesmedjan.webshop.controllers;

import org.springframework.data.repository.query.Param;
import tankesmedjan.webshop.services.ProductService;
import tankesmedjan.webshop.models.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/products")
public class ProductsController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public Products addProducts(@RequestBody Products product ) {
       return productService.addProduct(product);
    }

    @GetMapping
    public List<Products> getAllProducts() {
        return productService.getProducts();
    }

    @GetMapping("/featured")
    public List<Products> getAllFeaturedProducts() {
        return productService.getAllFeaturedProducts();
    }

    @GetMapping("/{id}")
    public List<Products> getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @GetMapping("/search")
    public List<Products> searchProduct(@Param("keyword") String keyword) {
        List<Products> searchResult = productService.searchProduct(keyword);
        return searchResult;
    }
}