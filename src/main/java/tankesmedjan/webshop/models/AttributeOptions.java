package tankesmedjan.webshop.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class AttributeOptions {

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
