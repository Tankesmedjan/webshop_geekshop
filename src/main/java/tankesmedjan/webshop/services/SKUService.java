package tankesmedjan.webshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tankesmedjan.webshop.models.Products;
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

    public SKU addSKU(SKU sku){
        return skuRepo.save(sku);
    }

    public List<SKU> getAllSku() { return skuRepo.findAll();}

    public List<SKU> getSKUsByProductId(Long id) { return skuRepo.findSKUSByProductsId(id); }

    public List<SKU> getSKUProduct(String sku) { return skuRepo.findBySku(sku); }

    public List<SKU> getSKUById(Long id) { return skuRepo.findById(id); }
}
