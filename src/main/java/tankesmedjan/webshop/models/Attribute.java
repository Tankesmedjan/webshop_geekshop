package tankesmedjan.webshop.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tankesmedjan.webshop.dto.AttributeDTO;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Attribute {

    public Attribute(AttributeDTO attribute) {
        this.attributeName = attribute.getAttribute_name();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String attributeName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "attribute")
    @JsonIgnore
    private List<AttributeOption> attributeOptions;

}
