package tn.esprit.yasserbenhajlacce10.service;

import tn.esprit.yasserbenhajlacce10.domain.Client;

import java.util.List;

public interface IClientServices {
    Client create(Client client);
    Client findById(long id);
    List<Client> findAll();
    void deleteById(long id);
    Client update(Client client);
}