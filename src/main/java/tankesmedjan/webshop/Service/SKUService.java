package tankesmedjan.webshop.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tankesmedjan.webshop.models.SKU;
import tankesmedjan.webshop.repos.SKURepo;

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
}
