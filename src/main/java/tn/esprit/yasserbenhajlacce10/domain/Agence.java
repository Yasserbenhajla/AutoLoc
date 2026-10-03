package tn.esprit.yasserbenhajlacce10.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.yasserbenhajlacce10.domain.Employe;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "agence")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Agence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgence;

    @Column(nullable = false, length = 100)
    private String nom;

    @Column(nullable = false, length = 50)
    private String ville;

    @Column(length = 150)
    private String adresse;

    @Column(length = 20)
    private String telephone;

    // ÉTAPE 1 : côtés inverses
    @OneToMany(mappedBy = "agence")
    private List<Vehicule> vehicules = new ArrayList<>();
    @OneToMany(mappedBy = "agence")
    private List<Employe> employes = new ArrayList<>();
}