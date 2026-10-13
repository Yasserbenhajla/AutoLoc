package tn.esprit.yasserbenhajlacce10.repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.yasserbenhajlacce10.domain.Reservation;

public interface IReservationRepository extends CrudRepository<Reservation,Long>{

}