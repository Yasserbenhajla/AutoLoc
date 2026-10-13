package tn.esprit.yasserbenhajlacce10.service.impls;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.yasserbenhajlacce10.domain.Contrat;
import tn.esprit.yasserbenhajlacce10.repository.IContratRepository;
import tn.esprit.yasserbenhajlacce10.service.IContratServices;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ContratServicesImpls implements IContratServices {
    private final IContratRepository contratRepository;

    @Override
    public Contrat create(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public Contrat findById(long id) {
        return contratRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Contrat> findAll() {
        return (List<Contrat>) contratRepository.findAll();
    }

    @Override
    public void deleteById(long id) {
        contratRepository.deleteById(id);
    }

    @Override
    public Contrat update(Contrat contrat) {
        return contratRepository.save(contrat);
    }
}