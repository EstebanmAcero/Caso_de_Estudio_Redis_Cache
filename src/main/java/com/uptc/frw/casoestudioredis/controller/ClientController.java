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
    @Autowired
    public ClientService clientService;

    @GetMapping
    public List<Client> getAllClients() {
        return clientService.findAllClient();
    }

    @GetMapping("{id}")
    @Cacheable(                         // Cachea los resultados de búsqueda por ID
            value = "clients",    // Nombre de la caché donde se almacena el resultado.
            key = "#id",          // Clave de la caché, en este caso el 'id' del cliente.
            unless = "#result == null" // No almacenar en caché si el resultado es 'null'.
    )
    public Client getClientById(@PathVariable long id) {
        long start = System.currentTimeMillis();
        Client client = clientService.findByIdClient(id);
        long end = System.currentTimeMillis();
        System.out.println("Tiempo de respuesta: " + (end - start) + " ms");
        return client;
    }

    @PostMapping
    @CachePut(
            value = "clients",
            key = "#client.idClient",
            unless = "#result == null" // No almacenar en caché si el resultado es 'null'.
    )
    public Client addClient(@RequestBody Client client) {
        long start = System.currentTimeMillis();
        Client savedClient = clientService.saveClient(client);
        long end = System.currentTimeMillis();
        System.out.println("Tiempo de respuesta para agregar cliente: " + (end - start) + " ms");
        return savedClient;
    }

    @PutMapping
    @CachePut(
            value = "clients",
            key = "#client.idClient",
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
        clientService.deleteClient(id);
        long end = System.currentTimeMillis();
        System.out.println("Tiempo de respuesta para eliminar cliente: " + (end - start) + " ms");
    }
}
