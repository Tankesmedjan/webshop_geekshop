package tankesmedjan.webshop.Service;

import org.springframework.stereotype.Service;
import tankesmedjan.webshop.models.Vat;
import tankesmedjan.webshop.repos.VatRepo;

import java.util.List;

@Service
public class VatService {

    private final VatRepo vatRepo;

    VatService(VatRepo vatRepo){
        this.vatRepo = vatRepo;
    }

    public List<Vat> getVats() {
        return vatRepo.findAll();
    }
}
