package tankesmedjan.webshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tankesmedjan.webshop.models.SKU;
import tankesmedjan.webshop.repos.SKURepo;

import java.util.List;

@Service
public class SKUService {

    private final SKURepo skuRepo;

    @Autowired
    public SKUService(SKURepo skuRepo){
        this.skuRepo = skuRepo;
    }

    //ToDo: Remove when confirmed working.
//    /**
//     *
//     * @param sku The body of a SKU (Stock keeping unit).
//     * @return the SKU.
//     */
//    public SKU addSKU(SKU sku){
//        return skuRepo.save(sku);
//    }

    /**
     * Gets all SKUs in the database.
     *
     * @return all SKUs.
     */
    public List<SKU> getAllSku() { return skuRepo.findAll();}

    /**
     *
     * @param id The ID of a Product that can contain several SKUs (variations of the product).
     * @return The list of SKUs related to the Product.
     */
    public List<SKU> getSKUsByProductId(Long id) { return skuRepo.findSKUSByProductId(id); }

    /**
     * The reason for List vs. single object is for the front-end to fetch correctly.
     *
     * @param sku the unique SKU (ex. 111-111-40).
     * @return The SKU related to the SKU.
     */
    public List<SKU> getSKUProduct(String sku) { return skuRepo.findBySku(sku); }

    /**
     * The reason for List vs. single object is for the front-end to fetch correctly.
     *
     * @param id the unique ID of an SKU.
     * @return The SKU related to the ID.
     */
    public List<SKU> getSKUById(Long id) { return skuRepo.findSKUById(id); }
}
