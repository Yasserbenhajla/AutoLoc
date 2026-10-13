package tn.esprit.yasserbenhajlacce10.service;

import tn.esprit.yasserbenhajlacce10.domain.Contrat;

import java.util.List;

public interface IContratServices {
    Contrat create(Contrat contrat);
    Contrat findById(long id);
    List<Contrat> findAll();
    void deleteById(long id);
    Contrat update(Contrat contrat);
}