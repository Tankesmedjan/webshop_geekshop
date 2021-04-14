package tankesmedjan.webshop.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import tankesmedjan.webshop.dto.ProductRatingDTO;
import tankesmedjan.webshop.models.ProductRating;
import tankesmedjan.webshop.services.ProductRatingService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/productrating")
public class ProductRatingController {

    @Autowired
    private ProductRatingService productRatingService;

    @PostMapping
    public ProductRatingDTO addProductRating(@RequestBody ProductRatingDTO productRatingDTO) {
        return productRatingService.addProductRating(productRatingDTO);
    }

    @GetMapping
    public List<ProductRating> getAllProductRating(@Param("id") Long id){

        return productRatingService.getAverageRatingsByProductIds(id); }
}
