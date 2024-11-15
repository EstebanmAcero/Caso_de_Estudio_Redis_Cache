package com.uptc.frw.casoestudioredis.controller;

import com.uptc.frw.casoestudioredis.services.RandomClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador para manejar las solicitudes HTTP relacionadas con la inserción de clientes aleatorios.
 * Permite insertar un número determinado de clientes en la base de datos a través de un servicio.
 */

@RestController
@RequestMapping("randomClients")
public class RandomClientController {

    // Servicio utilizado para generar y manejar la inserción de clientes aleatorios
    @Autowired
    private RandomClientService randomClientService;

    /**
     * Inserta un número predefinido de clientes aleatorios en la base de datos.
     * En este caso, se insertan 10,000 clientes.
     *
     * @return Mensaje indicando que los 10,000 clientes fueron insertados correctamente.
     */

    @PostMapping
    public String insertRandomClients() {
        int numberOfClients = 10000; // Número de clientes aleatorios a insertar
        // Llama al servicio para insertar los clientes aleatorios en la base de datos
        randomClientService.insertRandomClients(numberOfClients);
        // Retorna un mensaje indicando que la operación fue exitosa
        return "10,000 clients inserted successfully!";
    }
}
