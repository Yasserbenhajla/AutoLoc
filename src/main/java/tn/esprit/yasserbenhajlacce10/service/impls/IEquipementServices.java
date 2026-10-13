package tn.esprit.yasserbenhajlacce10.service;

import tn.esprit.yasserbenhajlacce10.domain.Equipement;

import java.util.List;

public interface IEquipementServices {
    Equipement create(Equipement equipement);
    Equipement findById(long id);
    List<Equipement> findAll();
    void deleteById(long id);
    Equipement update(Equipement equipement);
}