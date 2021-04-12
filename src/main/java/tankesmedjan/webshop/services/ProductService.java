package tankesmedjan.webshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tankesmedjan.webshop.dto.ProductDTO;
import tankesmedjan.webshop.mappers.ProductMapper;
import tankesmedjan.webshop.models.*;
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
     * @param productDTO holds information about the product and sku.
     *
     * skuService adds the sku to the database.
     * The sku then adds it's new id back to addNewProduct and it gets saved into the database.
     * If no ID is given to the added product the ID gets autogeneretated. If productID is given, in case of adding multiple
     * variations of same product, the given ID will be used. Same goes for attributeID.
     *
     */

    public ProductDTO addProduct(ProductDTO productDTO) {
        Product addNewProduct = ProductMapper.INSTANCE.productDTOtoProduct(productDTO);

        if (productDTO.getProductId() == null) {
            productRepo.save(addNewProduct);
            productDTO.setProductId(addNewProduct.getId());
        } else {
            productDTO.setProductId(productDTO.getProductId());
        }

        if (productDTO.getAttributeOptionId() == null) {
            productDTO.setAttributeOptionId(0L);
        }
        else {
            productDTO.setAttributeOptionId(productDTO.getAttributeOptionId());
        }

        SKU sku = new SKU(productDTO);
        skuService.addSKU(sku);

        return productDTO;
    }

    public ProductDTO editProduct(Long id, ProductDTO productDTO) {
        Product productToEdit = productRepo.findSingleProductById(id);
        productToEdit.setProductName(productDTO.getProductName());
        productToEdit.setFullDesc(productDTO.getFullDesc());
        productToEdit.setShortDesc(productDTO.getShortDesc());
        productToEdit.setIsFeatured(productDTO.isFeatured());
        productToEdit.setProductPrice(productDTO.getProductPrice());
        productRepo.save(productToEdit);
        return productDTO;
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
        productRepo.delete(product);
        return product;
    }
}
