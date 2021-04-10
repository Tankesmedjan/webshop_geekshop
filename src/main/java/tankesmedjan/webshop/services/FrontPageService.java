package tankesmedjan.webshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tankesmedjan.webshop.models.FrontpageBanner;
import tankesmedjan.webshop.models.FrontpageSlide;
import tankesmedjan.webshop.repos.FrontpageBannerRepo;
import tankesmedjan.webshop.repos.FrontpageSlideRepo;

@Service
public class FrontPageService {

    private final FrontpageSlideRepo frontpageSlideRepo;
    private final FrontpageBannerRepo frontpageBannerRepo;

    @Autowired
    FrontPageService(FrontpageSlideRepo frontpageSlideRepo, FrontpageBannerRepo frontpageBannerRepo){
        this.frontpageSlideRepo = frontpageSlideRepo;
        this.frontpageBannerRepo = frontpageBannerRepo;
    }

    public FrontpageSlide addSlides(FrontpageSlide frontpageSlide){
        return frontpageSlideRepo.save(frontpageSlide);
    }

    public FrontpageBanner addBanners(FrontpageBanner frontpageBanner){
        return frontpageBannerRepo.save(frontpageBanner);
    }

}
