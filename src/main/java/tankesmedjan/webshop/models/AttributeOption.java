package tankesmedjan.webshop.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tankesmedjan.webshop.dto.AttributeOptionDTO;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class AttributeOption {

    public AttributeOption(AttributeOptionDTO attributeOption) {
        this.attributeOptionName = attributeOption.getAttributeOptionName();
        this.attribute = new Attribute();
        this.attribute.setId(attributeOption.getAttribute());
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String attributeOptionName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attribute", nullable = true)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Attribute attribute;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "attributeOption")
    @JsonIgnore
    private List<SKU> sku;


}
