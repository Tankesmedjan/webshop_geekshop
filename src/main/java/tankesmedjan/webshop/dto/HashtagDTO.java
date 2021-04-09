package tankesmedjan.webshop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HashtagDTO {

    public int hashtagid;
    public String hashtagname;

    public HashtagDTO(int id, String hashtagname) {
        this.hashtagid = id;
        this.hashtagname = hashtagname;
    }
}
