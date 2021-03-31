package tankesmedjan.webshop.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tankesmedjan.webshop.dto.AddAttributeDTO;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Attribute {

    public Attribute(AddAttributeDTO attribute) {
        this.attribute_name = attribute.getAttribute_name();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String attribute_name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "attribute")
    @JsonIgnore
    private List<AttributeOptions> attributeOptions;

}
