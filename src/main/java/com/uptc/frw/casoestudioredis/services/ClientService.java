package com.uptc.frw.casoestudioredis.services;

import com.uptc.frw.casoestudioredis.jpa.model.Client;
import com.uptc.frw.casoestudioredis.jpa.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;  // Inyección de dependencia del repositorio

    /**
     * Guarda una lista de clientes en la base de datos.
     * @param clients lista de clientes a guardar
     * @return lista de clientes guardados
     */
    public List<Client> saveAllClients(List<Client> clients) {
        return clientRepository.saveAll(clients);  // Método de JpaRepository para guardar todos los clientes
    }

    /**
     * Obtiene todos los clientes de la base de datos.
     * @return lista de clientes
     */
    public List<Client> findAllClient() {
        return clientRepository.findAll();  // Método de JpaRepository para obtener todos los clientes
    }

    /**
     * Busca un cliente por su ID.
     * @param id ID del cliente
     * @return el cliente encontrado o null si no existe
     */
    public Client findByIdClient(Long id) {
        System.out.println("Encontrando cliente de la DB con ID : " + id);
        return clientRepository.findById(id).orElse(null);  // Busca el cliente por ID
    }

    /**
     * Guarda un cliente en la base de datos.
     * @param client cliente a guardar
     * @return el cliente guardado
     */
    public Client saveClient(Client client){
        System.out.println("Guardando Cliente" +client.getNameClient());
        return clientRepository.save(client);  // Método de JpaRepository para guardar el cliente
    }

    /**
     * Actualiza los datos de un cliente existente.
     * @param client cliente con los nuevos datos
     * @return el cliente actualizado
     */
    public Client updateClient(Client client){
        Client client1 = findByIdClient(client.getIdClient());  // Busca el cliente existente
        client1.setNameClient(client.getNameClient());
        client1.setLastNameClient(client.getLastNameClient());
        client1.setAddressClient(client.getAddressClient());
        client1.setPhoneClient(client.getPhoneClient());
        client1.setEmailClient(client.getEmailClient());
        System.out.println("Actualizando cliente" + client1.getNameClient());
        return clientRepository.save(client1);  // Guarda el cliente actualizado
    }

    /**
     * Elimina un cliente por su ID.
     * @param id ID del cliente a eliminar
     */
    public void deleteClient(long id){
        System.out.println("Se ha eliminado el cliente con ID " + id);
        clientRepository.deleteById(id);  // Elimina el cliente por su ID
    }
}
