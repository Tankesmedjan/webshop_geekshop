package tankesmedjan.webshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tankesmedjan.webshop.dto.AddProductRatingDTO;
import tankesmedjan.webshop.models.ProductRating;
import tankesmedjan.webshop.repos.ProductRatingRepo;

@Service
public class ProductRatingService {

private final ProductRatingRepo productRatingRepo;

@Autowired
    public ProductRatingService(ProductRatingRepo productRatingRepo){
    this.productRatingRepo = productRatingRepo;
}

public AddProductRatingDTO addProductRating(AddProductRatingDTO addProductRatingDTO){

    ProductRating addNewRating = new ProductRating(addProductRatingDTO);
    productRatingRepo.save(addNewRating);

    return addProductRatingDTO;
}

}
