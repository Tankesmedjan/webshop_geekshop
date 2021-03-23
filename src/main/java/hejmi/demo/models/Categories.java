package hejmi.demo.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Categories {

    @Id
    @Column(length = 10)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10)
    private Long parent_category_id;

    @Column(length = 32)
    private String category_name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "catid")
    private List<Products> product = new ArrayList<Products>();

}
