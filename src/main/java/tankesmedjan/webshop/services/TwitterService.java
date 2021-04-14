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

    /**
     * twitter.getPlaceTrends access the trending trends at a certain area(continent, country, state, city).
     * The stream streams the array of trending trends, maps the trend name into a object<HashtagDTO> and then
     * filter the stream to only preserve the trends containing a hashtag. Converts the stream into a list at the end.
     * @return a List<HashtagDTO> with trending hashtags in the UK.
     */
    public List<HashtagDTO> getHashtags() throws TwitterException {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        Trends trends = twitter.getPlaceTrends(23424975);

        return Arrays.stream(trends.getTrends())
                .map(trend -> new HashtagDTO(trend.getName()))
                .filter(h -> h.hashtagName.contains("#"))
                .collect(Collectors.toList());
    }

    /**
     * twitter.updateStatus() updates the status of the twitter account.
     * @param message contains the users input of a message, url and hashtag.
     * @return the input from the user with linebreaks.
     */
    public String postToTwitter(String message) throws TwitterException {
        Twitter twitter = TwitterFactory.getSingleton();
        twitter.updateStatus(message);
        return message;
    }
}
