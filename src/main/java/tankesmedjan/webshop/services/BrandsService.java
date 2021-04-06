package tankesmedjan.webshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tankesmedjan.webshop.dto.BrandsDTO;
import tankesmedjan.webshop.models.Brands;
import tankesmedjan.webshop.models.SKU;
import tankesmedjan.webshop.repos.BrandsRepo;
import tankesmedjan.webshop.repos.ProductsRepo;

import java.util.List;

@Service
public class BrandsService {

    @Autowired
    private BrandsRepo brandsRepo;

    @Autowired
    ProductsRepo productsRepo;

    public Brands saveBrand(Brands brands) {
        return brandsRepo.save(brands);
    }

    public List<Brands> findAll() {
        return brandsRepo.findAll();
    }

    public List<Brands> getBrand(Long id) {
        return brandsRepo.findById(id);
    }

    public List<SKU> getProductsByBrandId(Long id) {
        return productsRepo.findAllByBrands_Id(id);
   }


}
