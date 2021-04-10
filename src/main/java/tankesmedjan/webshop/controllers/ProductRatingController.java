package tankesmedjan.webshop.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tankesmedjan.webshop.dto.AddProductRatingDTO;
import tankesmedjan.webshop.services.ProductRatingService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/productrating")
public class ProductRatingController {

    @Autowired
    private ProductRatingService productRatingService;

    @PostMapping
    public AddProductRatingDTO addProducts(@RequestBody AddProductRatingDTO addProductRatingDTO ) {
        return productRatingService.addProductRating(addProductRatingDTO);
    }
}
