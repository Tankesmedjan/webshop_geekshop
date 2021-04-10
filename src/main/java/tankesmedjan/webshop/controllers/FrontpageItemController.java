package tankesmedjan.webshop.controllers;

import org.springframework.web.bind.annotation.*;
import tankesmedjan.webshop.services.FrontPageService;
import tankesmedjan.webshop.models.FrontpageBanner;
import tankesmedjan.webshop.models.FrontpageSlide;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/frontpageitems")
public class FrontpageItemController {

    @Autowired
    private FrontPageService frontPageService;

    @PostMapping("/slides")
    public FrontpageSlide addSlide(@RequestBody FrontpageSlide slide ) {
        frontPageService.addSlides(slide);
        return slide;
    }

    @PostMapping("/banners")
    public FrontpageBanner addBanner(@RequestBody FrontpageBanner banner ) {
        frontPageService.addBanners(banner);
        return banner;
    }
}
