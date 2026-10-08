package tn.esprit.yasserbenhajlacce10.service.impls;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.yasserbenhajlacce10.domain.Vehicule;
import tn.esprit.yasserbenhajlacce10.repository.IVehiculeRepository;
import tn.esprit.yasserbenhajlacce10.service.IVehiculeServices;

import java.util.List;
@RequiredArgsConstructor
@Service


public class VehiculeServicesImpls implements IVehiculeServices {
    private IVehiculeRepository vehiculeRepository ;


    @Override
    public Vehicule create(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public Vehicule findById(long id) {
        return vehiculeRepository.findById(id).orElseThrow();
    }


    @Override
    public List<Vehicule> findAll() {
        return (List<Vehicule>) vehiculeRepository.findAll();
    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public Vehicule update(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }
}
