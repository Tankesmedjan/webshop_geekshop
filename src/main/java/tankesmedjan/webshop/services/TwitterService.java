package tankesmedjan.webshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tankesmedjan.webshop.dto.HashtagDTO;
import tankesmedjan.webshop.repos.TwitterRepo;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TwitterService {

    private final TwitterRepo twitterRepo;

    @Autowired
    public TwitterService (TwitterRepo twitterRepo){
        this.twitterRepo = twitterRepo;
    }

    Logger logger = Logger.getLogger(TwitterRepo.class);

    public List<HashtagDTO> getHashtags() throws TwitterException {
        List<HashtagDTO> hashtags = new ArrayList<>();
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        Trends trends = twitter.getPlaceTrends(23424975);
        int count = 0;
        for (Trend trend : trends.getTrends()) {
            if (count < 10 && trend.getName().contains("#")) {
                HashtagDTO hashtagDTO = new HashtagDTO((count + 1), trend.getName());
                hashtags.add(hashtagDTO);
                count++;
            }
        }
        return hashtags;
    }

    public String postToTwitter(String message) throws TwitterException {
        Twitter twitter = TwitterFactory.getSingleton();
        Status status = twitter.updateStatus(message);
        logger.debug("Successfully updated status to " + status.getText());
        return message;
    }
}
