package tn.esprit.yasserbenhajlacce10.service.impls;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.yasserbenhajlacce10.domain.Contrat;
import tn.esprit.yasserbenhajlacce10.domain.Paiement;
import tn.esprit.yasserbenhajlacce10.domain.Reservation;

import tn.esprit.yasserbenhajlacce10.repository.IContratRepository;
import tn.esprit.yasserbenhajlacce10.repository.IReservationRepository;


import java.util.List;

@Service
@RequiredArgsConstructor
public class ContratServicesImpls implements IContratServices {

    private final IContratRepository contratRepository;
    private final IReservationRepository reservationRepository;

    @Override
    public Contrat create(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public Contrat findById(long id) {
        return contratRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contrat introuvable : " + id));
    }

    @Override
    public List<Contrat> findAll() {
        return contratRepository.findAll();
    }

    @Override
    public void deleteById(long id) {
        contratRepository.deleteById(id);
    }

    @Override
    public Contrat update(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    @Transactional
    public Contrat addWithPaiements(Contrat contrat) {
        // Un contrat est obligatoirement lié à une réservation existante (relation 1-1)
        if (contrat.getReservation() == null || contrat.getReservation().getIdReservation() == null) {
            throw new RuntimeException("Le contrat doit être lié à une réservation (reservation.idReservation)");
        }
        Long idReservation = contrat.getReservation().getIdReservation();
        Reservation reservation = reservationRepository.findById(idReservation)
                .orElseThrow(() -> new RuntimeException("Réservation introuvable : " + idReservation));
        contrat.setReservation(reservation);

        // Composition : chaque paiement doit connaître son contrat,
        // sinon la colonne contrat_id reste à NULL
        if (contrat.getPaiements() != null) {
            for (Paiement paiement : contrat.getPaiements()) {
                paiement.setContrat(contrat);
            }
        }
        // Un seul save : la cascade ALL enregistre aussi les paiements
        return contratRepository.save(contrat);
    }
}