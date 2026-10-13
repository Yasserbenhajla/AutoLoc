package tn.esprit.yasserbenhajlacce10.service;

import tn.esprit.yasserbenhajlacce10.domain.Agence;

import java.util.List;

public interface IAgenceServices {
    Agence create(Agence agence);
    Agence findById(long id);
    List<Agence> findAll();
    void deleteById(long id);
    Agence update(Agence agence);
}