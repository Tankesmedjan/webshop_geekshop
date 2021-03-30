package tankesmedjan.webshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tankesmedjan.webshop.models.Brands;
import tankesmedjan.webshop.models.Categories;
import tankesmedjan.webshop.models.Products;
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
        brandsRepo.save(brands);
        return brands;
    }

    public List<Brands> findAll() {
        return brandsRepo.findAll();
    }

    public List<Brands> getBrand(Long id) {
        return brandsRepo.findById(id);
    }

    public List<Products> getProductsByBrandId(Long id) {
        return productsRepo.findAllByBrands_Id(id);
    }

}
