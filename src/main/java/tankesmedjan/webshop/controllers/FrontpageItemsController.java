package tankesmedjan.webshop.controllers;

import org.springframework.web.bind.annotation.*;
import tankesmedjan.webshop.Service.FrontPageService;
import tankesmedjan.webshop.models.FrontpageBanners;
import tankesmedjan.webshop.models.FrontpageSlides;
import tankesmedjan.webshop.repos.FrontpageBannersRepo;
import tankesmedjan.webshop.repos.FrontpageSlidesRepo;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/frontpageitems")
public class FrontpageItemsController {

    @Autowired
    private FrontPageService frontPageService;

    @PostMapping("/slides")
    public FrontpageSlides addSlide(@RequestBody FrontpageSlides slide ) {
        frontPageService.addSlides(slide);
        return slide;
    }

    @PostMapping("/banners")
    public FrontpageBanners addBanner(@RequestBody FrontpageBanners banner ) {
        frontPageService.addBanners(banner);
        return banner;
    }
}
