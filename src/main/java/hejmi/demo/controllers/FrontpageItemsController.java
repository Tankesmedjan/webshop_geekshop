package hejmi.demo.controllers;

import hejmi.demo.models.FrontpageBanners;
import hejmi.demo.models.FrontpageSlides;
import hejmi.demo.models.Products;
import hejmi.demo.repos.FrontpageBannersRepo;
import hejmi.demo.repos.FrontpageSlidesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/frontpageitems")
public class FrontpageItemsController {

    @Autowired
    FrontpageBannersRepo frontpageBannersRepo;

    @Autowired
    FrontpageSlidesRepo frontpageSlidesRepo;

    @PostMapping("/slides")
    public FrontpageSlides addSlide(@RequestBody FrontpageSlides slide ) {
        frontpageSlidesRepo.save(slide);
        return slide;
    }

    @PostMapping("/banners")
    public FrontpageBanners addBanner(@RequestBody FrontpageBanners banner ) {
        frontpageBannersRepo.save(banner);
        return banner;
    }
}
