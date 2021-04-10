package tankesmedjan.webshop.services;

import org.springframework.stereotype.Service;
import tankesmedjan.webshop.models.Customer;
import tankesmedjan.webshop.repos.CustomerRepo;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepo customerRepo;

    CustomerService(CustomerRepo customerRepo){
        this.customerRepo = customerRepo;
    }

    public List<Customer> getCustomerAccount(String id) {
        return customerRepo.findByAccount_Id(id);
    }

    public Customer addCustomer(Customer customer) { return customerRepo.save(customer); }
}
