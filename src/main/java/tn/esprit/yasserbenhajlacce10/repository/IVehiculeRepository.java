package tn.esprit.yasserbenhajlacce10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.yasserbenhajlacce10.domain.Vehicule;

public interface IVehiculeRepository extends JpaRepository<Vehicule,Long> {

}
