package com.uptc.frw.casoestudioredis.services;

import com.uptc.frw.casoestudioredis.jpa.model.Client;
import com.uptc.frw.casoestudioredis.jpa.model.Manufacturer;
import com.uptc.frw.casoestudioredis.jpa.repository.ClientRepository;
import com.uptc.frw.casoestudioredis.jpa.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
@Service
public class RandomManufacturerService {
    @Autowired
    private ManufacturerRepository manufacturerRepository;

    private final Random random = new Random();

    public Manufacturer generateRandomManufacturer() {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setNameManufacturer("Fabricante" + random.nextInt(100000));
        manufacturer.setAddressManufacturer("Carrera " + random.nextInt(100000) + "#" + random.nextInt(100000));
        manufacturer.setPhoneManufacturer("1234" + random.nextInt(1000));
        manufacturer.setRifManufacturer("RIF" + random.nextInt(100000) + "@example.com");
        manufacturer.setFiscalDomicileManufacturer("FiscalDomicile" + random.nextInt(100000));
        return manufacturer;
    }

    public void insertRandomClients(int numberOfClients) {
        List<Manufacturer> manufacturers= new ArrayList<>();
        for (int i = 0; i < numberOfClients; i++) {
            manufacturers.add(generateRandomManufacturer());
        }
        manufacturerRepository.saveAll(manufacturers);
    }
}
