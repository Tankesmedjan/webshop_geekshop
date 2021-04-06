package tankesmedjan.webshop.repos;

import org.springframework.data.repository.CrudRepository;
import tankesmedjan.webshop.models.Customers;

import java.util.List;

public interface CustomersRepo extends CrudRepository<Customers, Integer> {
    public List<Customers> findByAccount_Id(String id);
}
