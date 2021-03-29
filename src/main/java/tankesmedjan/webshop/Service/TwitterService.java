package tankesmedjan.webshop.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tankesmedjan.webshop.repos.TwitterRepository;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TwitterService {

    private final TwitterRepository twitterRepository;

    @Autowired
    public TwitterService (TwitterRepository twitterRepository){
        this.twitterRepository = twitterRepository;
    }

    Logger logger = Logger.getLogger(TwitterRepository.class);

    public List<String> getHashtags() throws TwitterException {
        List<String> hashtags = new ArrayList<>();
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        Trends trends = twitter.getPlaceTrends(23424975);
        int count = 0;
        for (Trend trend : trends.getTrends()) {
            if (count < 10 && trend.getName().contains("#")) {
                hashtags.add(trend.getName());
                count++;
            }
        }
        return hashtags;
    }

    public void postToTwitter(String message) throws TwitterException {
        Twitter twitter = TwitterFactory.getSingleton();
        Status status = twitter.updateStatus(message);
        logger.debug("Successfully updated status to " + status.getText());
    }
}
