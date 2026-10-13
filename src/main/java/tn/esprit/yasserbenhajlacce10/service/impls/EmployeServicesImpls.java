package tn.esprit.yasserbenhajlacce10.service.impls;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.yasserbenhajlacce10.domain.Employe;
import tn.esprit.yasserbenhajlacce10.repository.IEmployeRepository;
import tn.esprit.yasserbenhajlacce10.service.IEmployeServices;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EmployeServicesImpls implements IEmployeServices {
    private final IEmployeRepository employeRepository;

    @Override
    public Employe create(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public Employe findById(long id) {
        return employeRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Employe> findAll() {
        return (List<Employe>) employeRepository.findAll();
    }

    @Override
    public void deleteById(long id) {
        employeRepository.deleteById(id);
    }

    @Override
    public Employe update(Employe employe) {
        return employeRepository.save(employe);
    }
}