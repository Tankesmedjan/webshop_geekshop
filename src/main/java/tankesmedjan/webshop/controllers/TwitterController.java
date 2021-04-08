package tankesmedjan.webshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tankesmedjan.webshop.dto.TwitterDTO;
import tankesmedjan.webshop.services.TwitterService;
import twitter4j.TwitterException;

import java.util.List;

@RestController
@RequestMapping(path = "/twitter")
public class TwitterController {

    private final TwitterService twitterService;

    @Autowired
    public TwitterController(TwitterService twitterService){
        this.twitterService = twitterService;
    }

    @GetMapping(path = "/trending-hashtags")
    public List<String> getTags() throws TwitterException {
        return twitterService.getHashtags();
    }

    @PostMapping(path = "/post-to-twitter")
    public String postToTwitter(@RequestBody TwitterDTO twitterDTO) throws TwitterException {
        twitterService.postToTwitter(String.format("%-" + (twitterDTO.getMessage().length() + 1) + "s", twitterDTO.getMessage()) + String.format("%-" + (twitterDTO.getUrl().length() + 1) + "s", twitterDTO.getUrl()) +
                twitterService.getHashtags().get(twitterDTO.getHashtag()));
        return String.format("%-" + (twitterDTO.getMessage().length() + 1) + "s", twitterDTO.getMessage()) + String.format("%-" + (twitterDTO.getUrl().length() + 1) + "s", twitterDTO.getUrl()) +
                twitterService.getHashtags().get(twitterDTO.getHashtag());
    }
}
