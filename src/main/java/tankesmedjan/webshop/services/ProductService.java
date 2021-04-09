package tankesmedjan.webshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tankesmedjan.webshop.dto.AddProductsDTO;
import tankesmedjan.webshop.models.Products;
import tankesmedjan.webshop.models.SKU;
import tankesmedjan.webshop.repos.ProductsRepo;
import tankesmedjan.webshop.repos.SKURepo;

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
        if (addProductsDTO.getProduct_id() == null) {
            addProductsDTO.setProduct_id(addNewProduct.getId());
        } else addProductsDTO.setProduct_id(addProductsDTO.getProduct_id());

        if (addProductsDTO.getAttributeoptionsid() == null) {
            addProductsDTO.setAttributeoptionsid(Long.valueOf(0));
        }
        else addProductsDTO.setAttributeoptionsid(addProductsDTO.getAttributeoptionsid());

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

    public List<SKU> searchProduct(String keyword) {
        if (keyword != null) {
            return productsRepo.searchProduct(keyword);
        }
        return skuService.getAllSku();
    }

    public Products deleteProduct(Long id) {
        Products product = productsRepo.findSingleProductById(id);
        List<SKU> SKUsToDelete = skuService.getSKUsByProductId(id);
        productsRepo.delete(product);
        return product;
    }
}
