package com.uptc.frw.casoestudioredis.services;

import com.uptc.frw.casoestudioredis.jpa.model.Client;
import com.uptc.frw.casoestudioredis.jpa.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

@Service
public class RandomClientService {

    @Autowired
    private ClientRepository clientRepository;

    private final Random random = new Random();

    public Client generateRandomClient() {
        Client client = new Client();
        client.setNameClient("Client_" + random.nextInt(100000));
        client.setLastNameClient("lastname"+random.nextInt(100000));
        client.setAddressClient("Avenida " + random.nextInt(100000) + "#" + random.nextInt(100000));
        client.setEmailClient("client" + random.nextInt(100000) + "@example.com");
        client.setPhoneClient("123456" + random.nextInt(1000));
        return client;
    }

    public void insertRandomClients(int numberOfClients) {
        List<Client> clients = new ArrayList<>();
        for (int i = 0; i < numberOfClients; i++) {
            clients.add(generateRandomClient());
        }
        clientRepository.saveAll(clients);
    }
}
