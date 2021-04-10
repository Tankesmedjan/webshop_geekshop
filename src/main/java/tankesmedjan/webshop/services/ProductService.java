package tankesmedjan.webshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tankesmedjan.webshop.dto.AddProductDTO;
import tankesmedjan.webshop.models.Product;
import tankesmedjan.webshop.models.SKU;
import tankesmedjan.webshop.repos.ProductRepo;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepo productRepo;

    @Autowired
    private SKUService skuService;

    @Autowired
    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    /**
     *
     * Method to add products, and creating a SKU with an entity connection between them.
     * @param addProductDTO holds information about the product and sku.
     *
     * skuService adds the sku to the database.
     * The sku then adds it's new id back to addNewProduct and it gets saved into the database.
     */

    public AddProductDTO addProduct(AddProductDTO addProductDTO) {
        Product addNewProduct = new Product(addProductDTO);
        productRepo.save(addNewProduct);
        if (addProductDTO.getProductId() == null) {
            addProductDTO.setProductId(addNewProduct.getId());
        } else addProductDTO.setProductId(addProductDTO.getProductId());

        if (addProductDTO.getAttributeOptionId() == null) {
            addProductDTO.setAttributeOptionId(0L);
        }
        else addProductDTO.setAttributeOptionId(addProductDTO.getAttributeOptionId());

        SKU sku = new SKU(addProductDTO);
        skuService.addSKU(sku);

        return addProductDTO;
    }

    public AddProductDTO editProduct(Long id, AddProductDTO addProductDTO) {
        Product productToEdit = productRepo.findSingleProductById(id);
        productToEdit.setProductName(addProductDTO.getProductName());
        productToEdit.setFullDesc(addProductDTO.getFullDesc());
        productToEdit.setShortDesc(addProductDTO.getShortDesc());
        productToEdit.setIsFeatured(addProductDTO.isFeatured());
        productToEdit.setProductPrice(addProductDTO.getProductPrice());
        productRepo.save(productToEdit);
        return addProductDTO;
    }

    public List<Product> getProducts() {
        return productRepo.findAll();
    }

    public List<SKU> getAllFeaturedProducts() {
        return productRepo.findAllIsfeatured();
    }

    public List<SKU> getProductById(Long id) {
        return productRepo.findProductsById(id);
    }

    public List<SKU> searchProduct(String keyword) {
        if (keyword != null) {
            return productRepo.searchProduct(keyword);
        }
        return skuService.getAllSku();
    }

    public Product deleteProduct(Long id) {
        Product product = productRepo.findSingleProductById(id);
        List<SKU> SKUsToDelete = skuService.getSKUsByProductId(id);
        productRepo.delete(product);
        return product;
    }
}
