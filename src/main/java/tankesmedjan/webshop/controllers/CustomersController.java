package tankesmedjan.webshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tankesmedjan.webshop.models.Customers;
import tankesmedjan.webshop.repos.CustomersRepo;
import tankesmedjan.webshop.services.CustomersService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/customer")
public class CustomersController {

    @Autowired
    private CustomersService customersService;

    @PostMapping
    public Customers addCustomer(@RequestBody Customers customers){
        customersService.addCustomers(customers);
        return customers;
    }

    @GetMapping("/{id}")
    public List<Customers> getCustomerAccount(@PathVariable String id){
        return customersService.getCustomerAccount(id);
    }
}
