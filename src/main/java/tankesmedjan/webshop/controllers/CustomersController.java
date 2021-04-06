package tankesmedjan.webshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tankesmedjan.webshop.models.Customers;
import tankesmedjan.webshop.models.Vat;
import tankesmedjan.webshop.services.CustomersService;
import tankesmedjan.webshop.services.VatService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/customer")
public class CustomersController {

    @Autowired
    private CustomersService customersService;

    @GetMapping("/{id}")
    public List<Customers> getCustomerAccount(@PathVariable String id){
        return customersService.getCustomerAccount(id);
    }
}
