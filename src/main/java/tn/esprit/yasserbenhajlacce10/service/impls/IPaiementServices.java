package tn.esprit.yasserbenhajlacce10.service;

import tn.esprit.yasserbenhajlacce10.domain.Paiement;

import java.util.List;

public interface IPaiementServices {
    Paiement create(Paiement paiement);
    Paiement findById(long id);
    List<Paiement> findAll();
    void deleteById(long id);
    Paiement update(Paiement paiement);
}