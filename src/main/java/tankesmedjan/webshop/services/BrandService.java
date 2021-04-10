package tankesmedjan.webshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tankesmedjan.webshop.models.Brand;
import tankesmedjan.webshop.models.SKU;
import tankesmedjan.webshop.repos.BrandRepo;
import tankesmedjan.webshop.repos.ProductRepo;

import java.util.List;

@Service
public class BrandService {

    @Autowired
    private BrandRepo brandRepo;

    @Autowired
    ProductRepo productRepo;

    public Brand saveBrand(Brand brand) {
        return brandRepo.save(brand);
    }

    public List<Brand> findAll() {
        return brandRepo.findAll();
    }

    public List<Brand> getBrand(Long id) {
        return brandRepo.findById(id);
    }

    public List<SKU> getProductsByBrandId(Long id) {
        return productRepo.findAllByBrands_Id(id);
   }



}
