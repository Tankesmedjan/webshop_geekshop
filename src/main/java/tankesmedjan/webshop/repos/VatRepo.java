package tankesmedjan.webshop.repos;

import tankesmedjan.webshop.models.Vat;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VatRepo extends CrudRepository<Vat, Integer> {
    public List<Vat> findAll();
}
