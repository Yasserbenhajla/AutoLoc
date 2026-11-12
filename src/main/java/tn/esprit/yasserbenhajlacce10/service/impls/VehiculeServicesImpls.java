package tn.esprit.yasserbenhajlacce10.service.impls;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.yasserbenhajlacce10.domain.Agence;
import tn.esprit.yasserbenhajlacce10.domain.Equipement;
import tn.esprit.yasserbenhajlacce10.domain.Vehicule;
import tn.esprit.yasserbenhajlacce10.repository.*;
import tn.esprit.yasserbenhajlacce10.service.IVehiculeServices;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehiculeServicesImpls implements IVehiculeServices {

    private final IVehiculeRepository vehiculeRepository;
    private final IAgenceRepository agenceRepository;
    private final IEquipementRepository equipementRepository;

    @Override
    public Vehicule create(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public Vehicule findById(long id) {
        return vehiculeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Véhicule introuvable : " + id));
    }

    @Override
    public List<Vehicule> findAll() {
        return vehiculeRepository.findAll();
    }

    @Override
    public void deleteById(long id) {
        vehiculeRepository.deleteById(id);
    }

    @Override
    public Vehicule update(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public Vehicule assignAgence(long idVehicule, long idAgence) {
        Vehicule vehicule = findById(idVehicule);
        Agence agence = agenceRepository.findById(idAgence)
                .orElseThrow(() -> new RuntimeException("Agence introuvable : " + idAgence));

        vehicule.setAgence(agence);
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public Vehicule assignEquipement(long idVehicule, long idEquipement) {
        Vehicule vehicule = findById(idVehicule);
        Equipement equipement = equipementRepository.findById(idEquipement)
                .orElseThrow(() -> new RuntimeException("Equipement introuvable : " + idEquipement));

        vehicule.getEquipements().add(equipement);
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public Vehicule unassignEquipement(long idVehicule, long idEquipement) {
        Vehicule vehicule = findById(idVehicule);

        if (!vehicule.getEquipements().removeIf(e -> e.getIdEquipement() == idEquipement)) {
            throw new RuntimeException("L'équipement " + idEquipement
                    + " n'est pas affecté au véhicule " + idVehicule);
        }

        return vehiculeRepository.save(vehicule);
    }

    @Override
    @Transactional
    public Vehicule addAndAssignAgence(Vehicule vehicule, Long agenceId) {
        Agence agence = agenceRepository.findById(agenceId)
                .orElseThrow(() -> new RuntimeException("Agence introuvable : " + agenceId));

        vehicule.setAgence(agence);
        // Un seul save : la cascade PERSIST enregistre aussi les équipements
        return vehiculeRepository.save(vehicule);
    }
}