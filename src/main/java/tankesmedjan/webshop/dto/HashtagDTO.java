package tankesmedjan.webshop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HashtagDTO {

    public int hashtagId;
    public String hashtagName;

    public HashtagDTO(int id, String hashtagName) {
        this.hashtagId = id;
        this.hashtagName = hashtagName;
    }
}
