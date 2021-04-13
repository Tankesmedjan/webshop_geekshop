package tankesmedjan.webshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tankesmedjan.webshop.models.FrontpageBanner;
import tankesmedjan.webshop.models.FrontpageSlide;
import tankesmedjan.webshop.repos.FrontpageBannerRepo;
import tankesmedjan.webshop.repos.FrontpageSlideRepo;

/**
 * Unused as of now, kept in case of future usage.
 */
@Service
public class FrontPageService {

    private final FrontpageSlideRepo frontpageSlideRepo;
    private final FrontpageBannerRepo frontpageBannerRepo;

    @Autowired
    FrontPageService(FrontpageSlideRepo frontpageSlideRepo, FrontpageBannerRepo frontpageBannerRepo) {
        this.frontpageSlideRepo = frontpageSlideRepo;
        this.frontpageBannerRepo = frontpageBannerRepo;
    }

    /**
     * The slides are used in the front-end carousel and hardcoded at the time of writing.
     *
     * @param frontpageSlide a frontpageSlide body.
     * @return the new frontpageSlide.
     */
    public FrontpageSlide addSlides(FrontpageSlide frontpageSlide) {
        return frontpageSlideRepo.save(frontpageSlide);
    }

    /**
     * The banners are located below the featured products and hardcoded at the time of writing.
     *
     * @param frontpageBanner a frontpageBanner body.
     * @return the new frontpageBanner.
     */
    public FrontpageBanner addBanners(FrontpageBanner frontpageBanner) {
        return frontpageBannerRepo.save(frontpageBanner);
    }

}
