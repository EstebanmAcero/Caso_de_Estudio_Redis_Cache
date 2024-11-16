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
    private ClientRepository clientRepository;  // Repositorio para interactuar con la base de datos de clientes

    private final Random random = new Random();  // Objeto Random para generar datos aleatorios

    /**
     * Genera un cliente con datos aleatorios.
     * @return un objeto de tipo Client con información generada aleatoriamente
     */
    public Client generateRandomClient() {
        Client client = new Client();

        // Asigna valores aleatorios a los atributos del cliente
        client.setNameClient("Client_" + random.nextInt(100000));  // Nombre aleatorio
        client.setLastNameClient("lastname" + random.nextInt(100000));  // Apellido aleatorio
        client.setAddressClient("Avenida " + random.nextInt(100000) + "#" + random.nextInt(100000));  // Dirección aleatoria
        client.setEmailClient("client" + random.nextInt(100000) + "@example.com");  // Correo electrónico aleatorio
        client.setPhoneClient("123456" + random.nextInt(1000));  // Teléfono aleatorio

        return client;
    }

    /**
     * Inserta una cantidad específica de clientes generados aleatoriamente en la base de datos.
     * @param numberOfClients número de clientes a generar e insertar
     */
    public void insertRandomClients(int numberOfClients) {
        List<Client> clients = new ArrayList<>();  // Lista para almacenar los clientes generados
        for (int i = 0; i < numberOfClients; i++) {
            clients.add(generateRandomClient());  // Genera y agrega un cliente aleatorio a la lista
        }
        clientRepository.saveAll(clients);  // Guarda todos los clientes generados en la base de datos
    }
}
