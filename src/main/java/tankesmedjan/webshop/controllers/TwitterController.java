package tankesmedjan.webshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tankesmedjan.webshop.dto.HashtagDTO;
import tankesmedjan.webshop.dto.TwitterDTO;
import tankesmedjan.webshop.services.TwitterService;
import twitter4j.TwitterException;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/api/twitter")
public class TwitterController {

    private final TwitterService twitterService;

    @Autowired
    public TwitterController(TwitterService twitterService){
        this.twitterService = twitterService;
    }

    @GetMapping(path = "/trending-hashtags")
    public List<HashtagDTO> getTags() throws TwitterException {
        return twitterService.getHashtags();
    }

    @PostMapping(path = "/post-to-twitter")
    public String postToTwitter(@RequestBody TwitterDTO twitterDTO) throws TwitterException {
        return twitterService.postToTwitter(twitterDTO.getMessage() + System.lineSeparator() + twitterDTO.getUrl() +
                System.lineSeparator() + twitterService.getHashtags().get(twitterDTO.getHashtag() - 1).hashtagname);

    }
}
