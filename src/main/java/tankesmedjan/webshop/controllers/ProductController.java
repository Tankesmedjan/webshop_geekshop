package tankesmedjan.webshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import tankesmedjan.webshop.dto.ProductDTO;
import tankesmedjan.webshop.models.Product;
import tankesmedjan.webshop.models.SKU;
import tankesmedjan.webshop.services.ProductService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping
    public ProductDTO addProducts(@RequestBody ProductDTO product) {
       return productService.addProduct(product);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getProducts();
    }

    @PutMapping("/edit")
    public ProductDTO editProduct(@Param("id") Long id, @RequestBody ProductDTO editProduct) {
        return productService.editProduct(id, editProduct);
    }

    @GetMapping("/featured")
    public List<SKU> getAllFeaturedProducts() {
        return productService.getAllFeaturedProducts();
    }

    @GetMapping("/product")
    public List<SKU> getProductById(@Param("id") Long id) {
        return productService.getProductById(id);
    }

    @GetMapping("/search")
    public List<SKU> searchProduct(@Param("keyword") String keyword) {
        List<SKU> searchResult = productService.searchProduct(keyword);
        return searchResult;
    }

    @DeleteMapping("/delete")
    public Product deleteProducts(@RequestParam Long id) {
        return productService.deleteProduct(id);
    }
}
