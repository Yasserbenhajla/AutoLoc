package tn.esprit.yasserbenhajlacce10.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "paiement")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Paiement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaiement;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal montant;

    private LocalDate datePaiement;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ModePaiement modePaiement;

    // Côté enfant : porte la clé étrangère contrat_id.
    // @JsonIgnore évite la boucle JSON contrat -> paiements -> contrat
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "contrat_id")
    private Contrat contrat;
}