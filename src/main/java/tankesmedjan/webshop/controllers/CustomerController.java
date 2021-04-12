package tankesmedjan.webshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import tankesmedjan.webshop.models.Customer;
import tankesmedjan.webshop.services.CustomerService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer){
        customerService.addCustomer(customer);
        return customer;
    }

    @GetMapping
    public List<Customer> getCustomerAccount(@Param("id") String id){
        return customerService.getCustomerAccount(id);
    }
}
