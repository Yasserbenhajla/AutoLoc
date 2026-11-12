package tn.esprit.yasserbenhajlacce10.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "contrat")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contrat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContrat;

    private LocalDate dateSignature;

    @Column(precision = 10, scale = 2)
    private BigDecimal montantTotal;

    private boolean valide;

    // Relation 1-1 avec Reservation : si ton entité a déjà sa propre version
    // de cette relation, garde la tienne à la place de ces deux lignes
    @OneToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    // Composition (losange plein côté Contrat) : Contrat est le parent.
    // cascade ALL + orphanRemoval : les paiements sont créés et supprimés avec le contrat
    @OneToMany(mappedBy = "contrat", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Paiement> paiements = new ArrayList<>();
}