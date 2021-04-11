package tankesmedjan.webshop.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Hashtag {
    @Id
    @Column(length = 100)
    private String Hashtag;
}
