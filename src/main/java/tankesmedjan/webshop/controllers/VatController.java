package tankesmedjan.webshop.controllers;

import org.springframework.web.bind.annotation.*;
import tankesmedjan.webshop.models.Vat;
import tankesmedjan.webshop.repos.VatRepo;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/vat")
public class VatController {

    @Autowired
    private VatRepo vatRepo;

    @PostMapping
    public Vat addBrand(@RequestBody Vat vat) {
        vatRepo.save(vat);
        return vat;
    }
}
