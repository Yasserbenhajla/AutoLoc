package tn.esprit.yasserbenhajlacce10.service.impls;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.yasserbenhajlacce10.domain.Client;
import tn.esprit.yasserbenhajlacce10.repository.IClientRepository;
import tn.esprit.yasserbenhajlacce10.service.IClientServices;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ClientServicesImpls implements IClientServices {
    private final IClientRepository clientRepository;

    @Override
    public Client create(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client findById(long id) {
        return clientRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Client> findAll() {
        return (List<Client>) clientRepository.findAll();
    }

    @Override
    public void deleteById(long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public Client update(Client client) {
        return clientRepository.save(client);
    }
}