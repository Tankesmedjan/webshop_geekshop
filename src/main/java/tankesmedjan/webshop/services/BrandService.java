package tankesmedjan.webshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tankesmedjan.webshop.dto.BrandDTO;
import tankesmedjan.webshop.mappers.BrandMapper;
import tankesmedjan.webshop.models.Brand;
import tankesmedjan.webshop.models.SKU;
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

    /**
     * Method to save a new Brand to the database.
     * @param brandDTO is the input from the user, and maps to the entity brand through mapstruct.
     * @return the input from the user.
     */
    public BrandDTO saveBrand(BrandDTO brandDTO) {
        Brand brand = BrandMapper.INSTANCE.dtoToBrand(brandDTO);
        brandRepo.save(brand);
        return brandDTO;
    }

    /**
     * @return a list of all brands in the database.
     */
    public List<Brand> findAll() {
        return brandRepo.findAll();
    }

    /**
     * @param id is the input from the user, and represent the id of a brand if it exists in the database.
     * @return the brand name and logo name.
     */
    public List<Brand> getBrand(Long id) {
        return brandRepo.findById(id);
    }

    /**
     * @param id is the input from the user, and represent the id of a brand if it exists in the database.
     * @return a list of all the products in the brand the id represents.
     */
    public List<SKU> getProductsByBrandId(Long id) {
        return productRepo.findAllByBrands_Id(id);
   }



}
