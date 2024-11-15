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
        return clientRepository.findAll();
    }

    public Client findByIdClient(Long id) {
        System.out.println("Encontrando cliente de la DB con ID : " + id);
        return clientRepository.findById(id).orElse(null);
    }

    public Client saveClient(Client client){
        System.out.println("Guardando Cliente" +client.getNameClient());
        return clientRepository.save(client);
    }
    public Client updateClient(Client client){
        Client client1= findByIdClient(client.getIdClient());
        client1.setNameClient(client.getNameClient());
        client1.setLastNameClient(client.getLastNameClient());
        client1.setAddressClient(client.getAddressClient());
        client1.setPhoneClient(client.getPhoneClient());
        client1.setEmailClient(client.getEmailClient());
        System.out.println("Actualizando cliente" +client1.getNameClient());
        return clientRepository.save(client1);
    }
    public void deleteClient(long id){
        System.out.println("Se ha eliminado el cliente con ID " + id);
        clientRepository.deleteById(id);
    }
}
