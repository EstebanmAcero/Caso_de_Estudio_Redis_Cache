package com.uptc.frw.casoestudioredis.controller;

import com.uptc.frw.casoestudioredis.services.RandomManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("randomManufacturers")
public class RandomManufacturerController {
    @Autowired
    private RandomManufacturerService randomManufacturerService;

    @PostMapping
    public String insertRandomManufacturers() {
        int numberOfClients = 10000;
        randomManufacturerService.insertRandomClients(numberOfClients);
        return "10,000 Fabricantes inserted successfully!";
    }
}
