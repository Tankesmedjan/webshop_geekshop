package hejmi.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Attribute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String attribute_name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "attribute")
    @JsonIgnore
    private List<AttributeOptions> attributeOptions;

}
