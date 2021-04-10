package tankesmedjan.webshop.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tankesmedjan.webshop.dto.AddCategoryDTO;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Category {

    public Category(AddCategoryDTO category) {
        this.categoryName = category.getCategoryName();
        this.parentCategoryId = category.getParentCategoryId();
    }

    @Id
    @Column(length = 10)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10)
    private Long parentCategoryId;

    @Column(length = 32)
    private String categoryName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    @JsonIgnore
    private List<Product> product;

}
