package hejmi.demo.controllers;

import hejmi.demo.models.Brands;
import hejmi.demo.repos.BrandsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brands")
public class BrandsController {

    @Autowired
    private BrandsRepo brandsRepo;

    @PostMapping
    public Brands addBrand(@RequestBody Brands brand) {
        brandsRepo.save(brand);
        return brand;
    }
}
