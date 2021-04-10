package tankesmedjan.webshop.repos;

import org.springframework.data.repository.CrudRepository;
import tankesmedjan.webshop.models.Customer;

import java.util.List;

public interface CustomerRepo extends CrudRepository<Customer, Integer> {
    public List<Customer> findByAccount_Id(String id);
}
