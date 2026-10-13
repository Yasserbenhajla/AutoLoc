package tn.esprit.yasserbenhajlacce10.service;

import tn.esprit.yasserbenhajlacce10.domain.Reservation;

import java.util.List;

public interface IReservationServices {
    Reservation create(Reservation reservation);
    Reservation findById(long id);
    List<Reservation> findAll();
    void deleteById(long id);
    Reservation update(Reservation reservation);
}