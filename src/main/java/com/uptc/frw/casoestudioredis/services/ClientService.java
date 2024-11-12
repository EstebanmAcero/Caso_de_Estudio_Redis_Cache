package com.uptc.frw.casoestudioredis.services;

import com.uptc.frw.casoestudioredis.jpa.model.Client;
import com.uptc.frw.casoestudioredis.jpa.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    public List<Client> findAllClient() {
        return clientRepository.findAll()
    }
    public Client findByIdClient(Long id){
        return clientRepository.findById(id).orElse(null);
    }
    public Client saveClient(Client client){
        return clientRepository.save(client);
    }
    public Client updateClient(Client client){
        Client client1= findByIdClient(client.getIdClient());
        client1.setNameClient(client.getNameClient());
        client1.setLastNameClient(client.getLastNameClient());
        client1.setAddressClient(client.getAddressClient());
        client1.setPhoneClient(client.getPhoneClient());
        client1.setEmailClient(client.getEmailClient());
        return clientRepository.save(client1);
    }
    public void deleteClient(Client client){
        clientRepository.delete(client);
    }
}
