package tn.esprit.yasserbenhajlacce10.service.impls;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.yasserbenhajlacce10.domain.Equipement;
import tn.esprit.yasserbenhajlacce10.repository.IEquipementRepository;
import tn.esprit.yasserbenhajlacce10.service.IEquipementServices;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EquipementServicesImpls implements IEquipementServices {
    private final IEquipementRepository equipementRepository;

    @Override
    public Equipement create(Equipement equipement) {
        return equipementRepository.save(equipement);
    }

    @Override
    public Equipement findById(long id) {
        return equipementRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Equipement> findAll() {
        return (List<Equipement>) equipementRepository.findAll();
    }

    @Override
    public void deleteById(long id) {
        equipementRepository.deleteById(id);
    }

    @Override
    public Equipement update(Equipement equipement) {
        return equipementRepository.save(equipement);
    }
}