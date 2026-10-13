package tn.esprit.yasserbenhajlacce10.service.impls;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.yasserbenhajlacce10.domain.Agence;
import tn.esprit.yasserbenhajlacce10.repository.IAgenceRepository;
import tn.esprit.yasserbenhajlacce10.service.IAgenceServices;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AgenceServicesImpls implements IAgenceServices {
    private final IAgenceRepository agenceRepository;

    @Override
    public Agence create(Agence agence) {
        return agenceRepository.save(agence);
    }

    @Override
    public Agence findById(long id) {
        return agenceRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Agence> findAll() {
        return (List<Agence>) agenceRepository.findAll();
    }

    @Override
    public void deleteById(long id) {
        agenceRepository.deleteById(id);
    }

    @Override
    public Agence update(Agence agence) {
        return agenceRepository.save(agence);
    }
}