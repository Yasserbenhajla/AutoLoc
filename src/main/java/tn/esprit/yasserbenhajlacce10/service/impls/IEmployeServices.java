package tn.esprit.yasserbenhajlacce10.service;

import tn.esprit.yasserbenhajlacce10.domain.Employe;

import java.util.List;

public interface IEmployeServices {
    Employe create(Employe employe);
    Employe findById(long id);
    List<Employe> findAll();
    void deleteById(long id);
    Employe update(Employe employe);
}