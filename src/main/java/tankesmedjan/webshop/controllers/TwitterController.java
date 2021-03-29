package tankesmedjan.webshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tankesmedjan.webshop.Service.TwitterService;
import twitter4j.TwitterException;

import java.util.List;

@RestController
@RequestMapping(path = "/twitter")
public class TwitterController {

    private TwitterService twitterService;

    @Autowired
    public TwitterController(TwitterService twitterService){
        this.twitterService = twitterService;
    }

    @GetMapping(path = "/trending-hashtags")
    public List<String> getTags() throws TwitterException {
        return twitterService.getHashtags();
    }

    @PostMapping(path = "/post-to-twitter")
    public String postToTwitter(@RequestParam String message, @RequestParam Integer id) throws TwitterException {
        twitterService.postToTwitter(message + twitterService.getHashtags().get(id));
        return message + " " + twitterService.getHashtags().get(id);
    }
}
