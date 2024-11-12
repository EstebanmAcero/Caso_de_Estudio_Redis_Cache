package com.uptc.frw.casoestudioredis.controller;

import com.uptc.frw.casoestudioredis.jpa.model.Client;
import com.uptc.frw.casoestudioredis.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clien")
public class ClientController {
    @Autowired
    public ClientService clientService;
    @GetMapping
    public List<Client> getAllClients(){
        return clientService.findAllClient();
    }
    @GetMapping("{id}")
    public Client getClientById(@PathVariable long id){
        return clientService.findByIdClient(id);
    }
    @PostMapping
    public Client addClient(@RequestBody Client client){
        return clientService.saveClient(client);
    }
    @PutMapping
    public Client updateClient(@RequestBody Client client){
        return clientService.updateClient(client);
    }
    @DeleteMapping
    public void deleteClient(@RequestParam long id){
        clientService.deleteClient(id);
    }
}
