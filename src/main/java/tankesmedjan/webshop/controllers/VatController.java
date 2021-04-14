package tankesmedjan.webshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tankesmedjan.webshop.models.Vat;
import tankesmedjan.webshop.services.VatService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/vat")
public class VatController {

    private final VatService vatService;

    @Autowired
    public VatController(VatService vatService){
        this.vatService = vatService;
    }

    @GetMapping
    public List<Vat> getVats(){
        return vatService.getVats();
    }
}
