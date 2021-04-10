package tankesmedjan.webshop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddCategoryDTO {

    private String categoryName;
    private Long parentCategoryId;

}
