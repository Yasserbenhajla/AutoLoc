package tn.esprit.yasserbenhajlacce10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.yasserbenhajlacce10.domain.Employe;

public interface IEmployeRepository extends JpaRepository<Employe,Long> {

}