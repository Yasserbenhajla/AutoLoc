package tn.esprit.yasserbenhajlacce10.service.impls;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.yasserbenhajlacce10.domain.Maintenance;
import tn.esprit.yasserbenhajlacce10.repository.IMaintenanceRepository;
import tn.esprit.yasserbenhajlacce10.service.IMaintenanceServices;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MaintenanceServicesImpls implements IMaintenanceServices {
    private final IMaintenanceRepository maintenanceRepository;

    @Override
    public Maintenance create(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }

    @Override
    public Maintenance findById(long id) {
        return maintenanceRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Maintenance> findAll() {
        return (List<Maintenance>) maintenanceRepository.findAll();
    }

    @Override
    public void deleteById(long id) {
        maintenanceRepository.deleteById(id);
    }

    @Override
    public Maintenance update(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }
}