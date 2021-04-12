package tankesmedjan.webshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tankesmedjan.webshop.dto.BrandDTO;
import tankesmedjan.webshop.models.Brand;
import tankesmedjan.webshop.models.SKU;
import tankesmedjan.webshop.repos.BrandMapper;
import tankesmedjan.webshop.repos.BrandRepo;
import tankesmedjan.webshop.repos.ProductRepo;

import java.util.List;

@Service
public class BrandService {

    private final BrandRepo brandRepo;

    private final ProductRepo productRepo;

    @Autowired
    public BrandService(BrandRepo brandRepo, ProductRepo productRepo){
        this.brandRepo = brandRepo;
        this.productRepo = productRepo;
    }

    public BrandDTO saveBrand(BrandDTO brandDTO) {
        Brand brand = BrandMapper.INSTANCE.dtoToBrand(brandDTO);
        brandRepo.save(brand);
        return brandDTO;
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
