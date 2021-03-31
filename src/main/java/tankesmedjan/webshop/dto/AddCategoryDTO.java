package tankesmedjan.webshop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddCategoryDTO {

    private String category_name;
    private Long parent_category_id;

}
