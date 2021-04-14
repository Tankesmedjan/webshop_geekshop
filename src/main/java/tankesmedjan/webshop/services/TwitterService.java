package tankesmedjan.webshop.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tankesmedjan.webshop.dto.HashtagDTO;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.*;
import java.util.stream.*;

@Service
@Transactional
public class TwitterService {

    Logger logger = Logger.getLogger(TwitterService.class);

    public List<HashtagDTO> getHashtags() throws TwitterException {

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        Trends trends = twitter.getPlaceTrends(23424975);

        var hash = Arrays.stream(trends.getTrends())
                .map(trend -> new HashtagDTO(trend.getName()))
                .filter(h -> h.hashtagName.contains("#"))
                .collect(Collectors.toList());
        return hash;
    }

    public String postToTwitter(String message) throws TwitterException {
        Twitter twitter = TwitterFactory.getSingleton();
        Status status = twitter.updateStatus(message);
        logger.debug("Successfully updated status to " + status.getText());
        return message;
    }
}
