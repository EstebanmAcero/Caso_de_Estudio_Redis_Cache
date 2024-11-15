package com.uptc.frw.casoestudioredis.controller;

import com.uptc.frw.casoestudioredis.jpa.model.Client;
import com.uptc.frw.casoestudioredis.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("client")
public class ClientController {

    /**
     * Controlador para la gestión de clientes utilizando Redis como sistema de caché
     * Permite realizar operaciones de CRUD sobre clientes
     */

    @Autowired
    public ClientService clientService;

    @GetMapping
    @Cacheable(
            value = "clients", // Nombre de la caché donde se almacenarán los resultados
            key = "'allClients'", // Clave para identificar el valor en la caché, en este caso una lista de todos los clientes
            unless = "#result == null" // No almacenar en caché si el resultado es nulo
    )

    // Obtiene todos los clientes desde la base de datos
    public List<Client> getAllClients() {
        long start = System.currentTimeMillis();
        List<Client> clients = clientService.findAllClient();
        long end = System.currentTimeMillis();  // Fin de la medición de tiempo de respuesta
        System.out.println("Tiempo de respuesta sin cache para consultar múltiples clientes: " + (end - start) + " ms");
        return clients;
    }

    @GetMapping("{id}")
    @Cacheable(                         // Cachea los resultados de búsqueda por ID
            value = "clients",    // Nombre de la caché donde se almacena el resultado.
            key = "#id",          // Clave de la caché, en este caso el 'id' del cliente.
            unless = "#result == null" // No almacenar en caché si el resultado es 'null'.
    )
    public Client getClientById(@PathVariable long id) {
        long start = System.currentTimeMillis(); // Inicio de medición de tiempo de respuesta
        // Busca un cliente específico en la base de datos utilizando el ID
        Client client = clientService.findByIdClient(id);
        long end = System.currentTimeMillis(); // Fin de la medición de tiempo de respuesta
        System.out.println("Tiempo de respuesta sin cache: " + (end - start) + " ms");
        return client;
    }

    @PostMapping
    @CachePut(
            value = "clients", // Nombre de la caché donde se almacenará el cliente agregado
            key = "#client.idClient", // Clave en la caché, basada en el ID del cliente recién agregado.
            unless = "#result == null" // No almacenar en caché si el resultado es nulo
    )
    public Client addClient(@RequestBody Client client) {
        long start = System.currentTimeMillis();
        Client savedClient = clientService.saveClient(client);
        long end = System.currentTimeMillis();
        System.out.println("Tiempo de respuesta para agregar cliente: " + (end - start) + " ms");
        return savedClient;
    }

    @PostMapping("/generate")
    public List<Client> addMultipleClients(@RequestBody List<Client> clients) {
        long start = System.currentTimeMillis();
        // Guarda múltiples clientes en la base de datos
        List<Client> savedClients = clientService.saveAllClients(clients);
        long end = System.currentTimeMillis();
        System.out.println("Tiempo de respuesta para agregar múltiples clientes: " + (end - start) + " ms");
        return savedClients;
    }

    @PutMapping
    @CachePut(
            value = "clients", // Nombre de la caché donde se almacenará el cliente actualizado
            key = "#client.idClient", // Clave en la caché basada en el ID del cliente actualizado
            unless = "#result == null" // No almacenar en caché si el resultado es 'null'.
    )
    public Client updateClient(@RequestBody Client client) {
        long start = System.currentTimeMillis();
        Client existingClient = clientService.findByIdClient(client.getIdClient());
        if (existingClient == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found");
        }
        Client updatedClient = clientService.updateClient(client);
        long end = System.currentTimeMillis();
        System.out.println("Tiempo de respuesta para actualizar cliente: " + (end - start) + " ms");
        return updatedClient;
    }

    @DeleteMapping
    @CacheEvict(
            value = "clients",
            key = "#id"
    )
    public void deleteClient(@RequestParam long id) {
        long start = System.currentTimeMillis();
        // Elimina un cliente de la base de datos utilizando su ID
        clientService.deleteClient(id);
        long end = System.currentTimeMillis();
        System.out.println("Tiempo de respuesta para eliminar cliente: " + (end - start) + " ms");
    }
}
