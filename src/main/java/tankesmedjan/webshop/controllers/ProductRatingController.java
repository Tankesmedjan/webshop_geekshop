package tankesmedjan.webshop.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tankesmedjan.webshop.dto.ProductRatingDTO;
import tankesmedjan.webshop.services.ProductRatingService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/productrating")
public class ProductRatingController {

    @Autowired
    private ProductRatingService productRatingService;

    @PostMapping
    public ProductRatingDTO addProducts(@RequestBody ProductRatingDTO productRatingDTO) {
        return productRatingService.addProductRating(productRatingDTO);
    }
}
