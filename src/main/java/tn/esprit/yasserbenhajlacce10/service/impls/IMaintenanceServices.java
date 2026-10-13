package tn.esprit.yasserbenhajlacce10.service;

import tn.esprit.yasserbenhajlacce10.domain.Maintenance;

import java.util.List;

public interface IMaintenanceServices {
    Maintenance create(Maintenance maintenance);
    Maintenance findById(long id);
    List<Maintenance> findAll();
    void deleteById(long id);
    Maintenance update(Maintenance maintenance);
}