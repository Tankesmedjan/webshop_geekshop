package tankesmedjan.webshop.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tankesmedjan.webshop.models.FrontpageBanners;
import tankesmedjan.webshop.models.FrontpageSlides;
import tankesmedjan.webshop.repos.FrontpageBannersRepo;
import tankesmedjan.webshop.repos.FrontpageSlidesRepo;

@Service
public class FrontPageService {

    private final FrontpageSlidesRepo frontpageSlidesRepo;
    private final FrontpageBannersRepo frontpageBannersRepo;

    @Autowired
    FrontPageService(FrontpageSlidesRepo frontpageSlidesRepo, FrontpageBannersRepo frontpageBannersRepo){
        this.frontpageSlidesRepo = frontpageSlidesRepo;
        this.frontpageBannersRepo = frontpageBannersRepo;
    }

    public FrontpageSlides addSlides(FrontpageSlides frontpageSlides){
        return frontpageSlidesRepo.save(frontpageSlides);
    }

    public FrontpageBanners addBanners(FrontpageBanners frontpageBanners){
        return frontpageBannersRepo.save(frontpageBanners);
    }

}
