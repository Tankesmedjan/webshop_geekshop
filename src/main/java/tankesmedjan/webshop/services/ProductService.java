package tankesmedjan.webshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tankesmedjan.webshop.dto.AddProductsDTO;
import tankesmedjan.webshop.models.AttributeOptions;
import tankesmedjan.webshop.models.Products;
import tankesmedjan.webshop.models.SKU;
import tankesmedjan.webshop.repos.ProductsRepo;

import java.util.List;

@Service
public class ProductService {

    private final ProductsRepo productsRepo;

    @Autowired
    private SKUService skuService;

    @Autowired
    public ProductService(ProductsRepo productsRepo) {
        this.productsRepo = productsRepo;
    }

    /**
     *
     * Method to add products, and creating a SKU with an entity connection between them.
     * @param addProductsDTO holds information about the product and sku.
     *
     * skuService adds the sku to the database.
     * The sku then adds it's new id back to addNewProduct and it gets saved into the database.
     */

    public AddProductsDTO addProduct(AddProductsDTO addProductsDTO) {


        Products addNewProduct = new Products(addProductsDTO);
        productsRepo.save(addNewProduct);
        addProductsDTO.setProduct_id(addNewProduct.getId());

        addProductsDTO.setAttributeoptionsid(Long.valueOf(0));

        SKU sku = new SKU(addProductsDTO);
        skuService.addSKU(sku);

        return addProductsDTO;
    }

    public List<Products> getProducts() {
        return productsRepo.findAll();
    }

    public List<SKU> getAllFeaturedProducts() {
        return productsRepo.findAllIsfeatured();
    }

    public List<SKU> getProductById(Long id) {
        return productsRepo.findProductsById(id);
    }

    public List<Products> searchProduct(String keyword) {
        if (keyword != null) {
            return productsRepo.searchProduct(keyword);
        }
        return productsRepo.findAll();
    }
}
