package tankesmedjan.webshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tankesmedjan.webshop.dto.ProductDTO;
import tankesmedjan.webshop.dto.SkuDTO;
import tankesmedjan.webshop.mappers.ProductMapper;
import tankesmedjan.webshop.mappers.SkuMapper;
import tankesmedjan.webshop.models.*;
import tankesmedjan.webshop.repos.ProductRepo;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepo productRepo;
    private final SKUService skuService;

    @Autowired
    public ProductService(ProductRepo productRepo, SKUService skuService) {
        this.productRepo = productRepo;
        this.skuService = skuService;
    }

    /**
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

        SkuDTO skuDTO = new SkuDTO(productDTO);
        SKU sku = SkuMapper.INSTANCE.dtoToSku(skuDTO);
        skuService.addSKU(sku);

        return productDTO;
    }

    /**
     * The function is used in the frontend and fetch all the values so no value untouched will be null
     * unless they were null prior to editing.
     *
     * @param id the id of the product to edit.
     * @param productDTO the values to be edited.
     * @return the edited Product.
     */
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

    /**
     *
     * @return a list of all Products in the database.
     */
    public List<Product> getProducts() {
        return productRepo.findAll();
    }

    /**
     *
     * @return a list of all Products that are featured (isFeatured is true).
     */
    public List<SKU> getAllFeaturedProducts() {
        return productRepo.findAllIsfeatured();
    }

    /**
     * The reason for List vs. single object is for the front-end to fetch correctly.
     *
     * @param id the ID of a product.
     * @return the Product related to the ID.
     */
    public List<SKU> getProductById(Long id) {
        return productRepo.findProductsById(id);
    }

    /**
     *
     * @param keyword can be either name of Product, Category or Brand.
     * @return a list of Products related to either of the conditions in keyword.
     */
    public List<SKU> searchProduct(String keyword) {
        if (keyword != null) {
            return productRepo.searchProduct(keyword);
        }
        return skuService.getAllSku();
    }

    /**
     *
     * @param id the ID of a product.
     * @return the deleted product.
     */
    public Product deleteProduct(Long id) {
        Product product = productRepo.findSingleProductById(id);
        productRepo.delete(product);
        return product;
    }
}
