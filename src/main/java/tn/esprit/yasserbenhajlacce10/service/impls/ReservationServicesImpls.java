package tn.esprit.yasserbenhajlacce10.service.impls;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.yasserbenhajlacce10.domain.Reservation;
import tn.esprit.yasserbenhajlacce10.repository.IReservationRepository;
import tn.esprit.yasserbenhajlacce10.service.IReservationServices;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ReservationServicesImpls implements IReservationServices {
    private final IReservationRepository reservationRepository;

    @Override
    public Reservation create(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation findById(long id) {
        return reservationRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Reservation> findAll() {
        return (List<Reservation>) reservationRepository.findAll();
    }

    @Override
    public void deleteById(long id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public Reservation update(Reservation reservation) {
        return reservationRepository.save(reservation);
    }
}