package tankesmedjan.webshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tankesmedjan.webshop.models.Vat;
import tankesmedjan.webshop.repos.VatRepo;

import java.util.List;

/**
 * Unused as of now, kept in case of future usage.
 */
@Service
public class VatService {

    private final VatRepo vatRepo;

    @Autowired
    public VatService(VatRepo vatRepo){
        this.vatRepo = vatRepo;
    }

    /**
     *
     * @return a list of all Vats.
     */
    public List<Vat> getVats() {
        return vatRepo.findAll();
    }
}
