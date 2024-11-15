package com.uptc.frw.casoestudioredis.controller;

import com.uptc.frw.casoestudioredis.services.RandomManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador para manejar las solicitudes HTTP relacionadas con la inserción de fabricantes aleatorios.
 * Permite insertar un número determinado de fabricantes en la base de datos a través de un servicio.
 */

@RestController
@RequestMapping("randomManufacturers")
public class RandomManufacturerController {
    // Servicio utilizado para generar y manejar la inserción de fabricantes aleatorios
    @Autowired
    private RandomManufacturerService randomManufacturerService;

    /**
     * Inserta un número predefinido de fabricantes aleatorios en la base de datos.
     * En este caso, se insertan 10,000 fabricantes.
     *
     * @return Mensaje indicando que los 10,000 fabricantes fueron insertados correctamente.
     */

    @PostMapping
    public String insertRandomManufacturers() {
        int numberOfClients = 10000; // Número de fabricantes aleatorios a insertar
        // Llama al servicio para insertar los fabricantes aleatorios en la base de datos
        randomManufacturerService.insertRandomClients(numberOfClients);
        // Retorna un mensaje indicando que la operación fue exitosa
        return "10,000 Fabricantes inserted successfully!";
    }
}
