package tn.esprit.yasserbenhajlacce10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.yasserbenhajlacce10.domain.Agence;

public interface IAgenceRepository extends JpaRepository<Agence,Long> {

}