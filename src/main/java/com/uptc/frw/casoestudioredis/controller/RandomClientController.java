package com.uptc.frw.casoestudioredis.controller;

import com.uptc.frw.casoestudioredis.services.RandomClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("randomClients")
public class RandomClientController {

    @Autowired
    private RandomClientService randomClientService;

    @PostMapping
    public String insertRandomClients() {
        int numberOfClients = 10000;
        randomClientService.insertRandomClients(numberOfClients);
        return "10,000 clients inserted successfully!";
    }
}
