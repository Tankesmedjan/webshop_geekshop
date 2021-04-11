package tankesmedjan.webshop.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class FrontpageSlide {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String slideTitle;
    private String slideContent;
    private Integer slideOrder;
    private String targetUrl;
    private String imageUrl;

}
