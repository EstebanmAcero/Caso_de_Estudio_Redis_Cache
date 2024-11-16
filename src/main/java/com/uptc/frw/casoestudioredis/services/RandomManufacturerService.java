package com.uptc.frw.casoestudioredis.services;

import com.uptc.frw.casoestudioredis.jpa.model.Manufacturer;
import com.uptc.frw.casoestudioredis.jpa.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class RandomManufacturerService {

    @Autowired
    private ManufacturerRepository manufacturerRepository;  // Repositorio para interactuar con la base de datos de fabricantes

    private final Random random = new Random();  // Objeto Random para generar datos aleatorios

    /**
     * Genera un fabricante con datos aleatorios.
     * @return un objeto de tipo Manufacturer con información generada aleatoriamente
     */
    public Manufacturer generateRandomManufacturer() {
        Manufacturer manufacturer = new Manufacturer();

        // Asigna valores aleatorios a los atributos del fabricante
        manufacturer.setNameManufacturer("Fabricante" + random.nextInt(100000));  // Nombre aleatorio
        manufacturer.setAddressManufacturer("Carrera " + random.nextInt(100000) + "#" + random.nextInt(100000));  // Dirección aleatoria
        manufacturer.setPhoneManufacturer("1234" + random.nextInt(1000));  // Teléfono aleatorio
        manufacturer.setRifManufacturer("RIF" + random.nextInt(100000) + "@example.com");  // RIF aleatorio
        manufacturer.setFiscalDomicileManufacturer("FiscalDomicile" + random.nextInt(100000));  // Domicilio fiscal aleatorio

        return manufacturer;
    }

    /**
     * Inserta una cantidad específica de fabricantes generados aleatoriamente en la base de datos.
     * @param numberOfManufacturers número de fabricantes a generar e insertar
     */
    public void insertRandomManufacturers(int numberOfManufacturers) {
        List<Manufacturer> manufacturers = new ArrayList<>();  // Lista para almacenar los fabricantes generados
        for (int i = 0; i < numberOfManufacturers; i++) {
            manufacturers.add(generateRandomManufacturer());  // Genera y agrega un fabricante aleatorio a la lista
        }
        manufacturerRepository.saveAll(manufacturers);  // Guarda todos los fabricantes generados en la base de datos
    }
}
