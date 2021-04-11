package tankesmedjan.webshop.repos;

import org.springframework.data.repository.CrudRepository;
import tankesmedjan.webshop.models.Vat;

import java.util.List;

public interface VatRepo extends CrudRepository<Vat, Integer> {
    public List<Vat> findAll();
}
