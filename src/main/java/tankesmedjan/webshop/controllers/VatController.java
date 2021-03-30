package tankesmedjan.webshop.controllers;

import org.springframework.web.bind.annotation.*;
import tankesmedjan.webshop.services.VatService;
import tankesmedjan.webshop.models.Vat;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/vat")
public class VatController {

    @Autowired
    private VatService vatService;

    @GetMapping
    public List<Vat> getVats(){
        return vatService.getVats();
    }
}
