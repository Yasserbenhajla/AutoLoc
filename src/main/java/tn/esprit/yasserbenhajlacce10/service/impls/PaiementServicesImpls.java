package tn.esprit.yasserbenhajlacce10.service.impls;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.yasserbenhajlacce10.domain.Paiement;
import tn.esprit.yasserbenhajlacce10.repository.IPaiementRepository;
import tn.esprit.yasserbenhajlacce10.service.IPaiementServices;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PaiementServicesImpls implements IPaiementServices {
    private final IPaiementRepository paiementRepository;

    @Override
    public Paiement create(Paiement paiement) {
        return paiementRepository.save(paiement);
    }

    @Override
    public Paiement findById(long id) {
        return paiementRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Paiement> findAll() {
        return (List<Paiement>) paiementRepository.findAll();
    }

    @Override
    public void deleteById(long id) {
        paiementRepository.deleteById(id);
    }

    @Override
    public Paiement update(Paiement paiement) {
        return paiementRepository.save(paiement);
    }
}