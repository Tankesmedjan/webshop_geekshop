package tankesmedjan.webshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tankesmedjan.webshop.models.Customer;
import tankesmedjan.webshop.repos.CustomerRepo;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepo customerRepo;

    @Autowired
    public CustomerService(CustomerRepo customerRepo){
        this.customerRepo = customerRepo;
    }

    /**
     *
     * @param id the id of a customer.
     * @return the customer related to the id.
     */
    public List<Customer> getCustomerAccount(String id) {
        return customerRepo.findByAccount_Id(id);
    }

    /**
     *
     * @param customer the body of a customer entity.
     * @return the new customer.
     */
    public Customer addCustomer(Customer customer) { return customerRepo.save(customer); }
}
