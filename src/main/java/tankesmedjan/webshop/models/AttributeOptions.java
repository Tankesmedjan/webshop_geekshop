package tankesmedjan.webshop.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tankesmedjan.webshop.dto.AddAttributeOptionDTO;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class AttributeOptions {

    public AttributeOptions(AddAttributeOptionDTO attributeOption) {
        this.attribute_option_name = attributeOption.getAttribute_option_name();
        this.attribute = new Attribute();
        this.attribute.setId(attributeOption.getAttribute());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String attribute_option_name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attribute", nullable = true)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Attribute attribute;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "attributeOptions")
    @JsonIgnore
    private List<SKU> sku;
}
