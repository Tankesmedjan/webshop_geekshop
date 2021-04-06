package tankesmedjan.webshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tankesmedjan.webshop.dto.BrandsDTO;
import tankesmedjan.webshop.dto.SkuDTO;
import tankesmedjan.webshop.models.Brands;
import tankesmedjan.webshop.models.SKU;
import tankesmedjan.webshop.repos.BrandsRepo;
import tankesmedjan.webshop.repos.ProductsRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrandsService {

    @Autowired
    private BrandsRepo brandsRepo;

    @Autowired
    ProductsRepo productsRepo;

    /**
     * Saves new brands into the database.
     * @param brandsDTO contains info about the new brand.
     */
    public BrandsDTO saveBrand(BrandsDTO brandsDTO) {
        Brands brands = new Brands(brandsDTO);
        brandsRepo.save(brands);
        return brandsDTO;
    }

    public List<Brands> findAll() {
        return brandsRepo.findAll();
    }

    public List<Brands> getBrand(Long id) {
        return brandsRepo.findById(id);
    }

    /**
     * returns a list of products in the brand the user search for with relevant information.
     * The sku object contains a lot of information, but only gives away the relevant info to skuDTO
     * which is shown for the user.
     * @param id represent the id of the brand the user search for.
     */

    public List<SkuDTO> getProductsByBrandId(Long id) {
        List<SkuDTO> skuList = new ArrayList<>();
        for(int i = 0; i < productsRepo.findAllByBrands_Id(id).size(); i++){
            SKU sku = productsRepo.findAllByBrands_Id(id).get(i);
            SkuDTO skuDTO = new SkuDTO(sku.getSku(), sku.getProducts().getBrands().getBrand_name(),
                    sku.getProducts().getCategory().getCategory_name(), sku.getProducts().getProduct_name(), sku.getProducts().getProduct_price(),
                    sku.getAttributeOptions().getAttribute_option_name(), sku.getStock());
            skuList.add(skuDTO);
        }
        return skuList;
   }


}
