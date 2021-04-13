package tankesmedjan.webshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import tankesmedjan.webshop.dto.BrandDTO;
import tankesmedjan.webshop.models.Brand;
import tankesmedjan.webshop.models.SKU;
import tankesmedjan.webshop.services.BrandService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/brands")
public class BrandController {

    private final BrandService brandService;

    @Autowired
    public BrandController(BrandService brandService){
        this.brandService = brandService;
    }

    @GetMapping
    public List<Brand> getAllBrands() {
        return brandService.findAll();
    }

    @PostMapping
    public BrandDTO addBrand(@RequestBody BrandDTO brandDTO) {
        return brandService.saveBrand(brandDTO);
    }

    @GetMapping("/id")
    public List<SKU> getAllProductsFromBrand(@Param("id") Long id) {
        return brandService.getProductsByBrandId(id);
    }

    @GetMapping("/brand")
    public List<Brand> getBrand(@Param("id") Long id) {
        return brandService.getBrand(id);
    }
}
