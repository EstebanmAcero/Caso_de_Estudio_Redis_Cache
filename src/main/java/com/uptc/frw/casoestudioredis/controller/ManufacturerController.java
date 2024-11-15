package com.uptc.frw.casoestudioredis.controller;

import com.uptc.frw.casoestudioredis.jpa.model.Client;
import com.uptc.frw.casoestudioredis.jpa.model.Manufacturer;
import com.uptc.frw.casoestudioredis.services.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("manufacturer")
public class ManufacturerController {
    @Autowired
    private ManufacturerService manufacturerService;
    @GetMapping
    public List<Manufacturer> getAllManufacturers() {
        return manufacturerService.findAllManufacturer();
    }
    @GetMapping("id")
    @Cacheable(                         // Cachea los resultados de búsqueda por ID
            value = "manufacturer",    // Nombre de la caché donde se almacena el resultado.
            key = "#id",          // Clave de la caché, en este caso el 'id' del fabricante.
            unless = "#result == null" // No almacenar en caché si el resultado es 'null'.
    )
    public Manufacturer getManufacturerById(@PathVariable long id) {
        long start = System.currentTimeMillis();
        Manufacturer manufacturer = manufacturerService.findManufacturerById(id);
        long end = System.currentTimeMillis();
        System.out.println("Tiempo de respuesta: " + (end - start) + " ms");
        return manufacturer;
    }
    @PostMapping
    @CachePut(
            value = "manufacturer",
            key = "#manufacturer.idManufacturer",
            unless = "#result == null" // No almacenar en caché si el resultado es 'null'.
    )
    public Manufacturer addManufacturer(@RequestBody Manufacturer manufacturer){
        long start = System.currentTimeMillis();
        Manufacturer saveManufacturer  = manufacturerService.saveManufacturer(manufacturer);
        long end = System.currentTimeMillis();
        System.out.println("Tiempo de respuesta para agregar fabricante: " + (end - start) + " ms");
        return saveManufacturer;
    }
    @PostMapping("/generate")
    public List<Manufacturer> addMultipleManufacturers(@RequestBody List<Manufacturer> manufacturers) {
        long start = System.currentTimeMillis();
        List<Manufacturer> savedManufacturers = manufacturerService.saveAllManufacturers(manufacturers);
        long end = System.currentTimeMillis();
        System.out.println("Tiempo de respuesta para agregar múltiples fabricantes: " + (end - start) + " ms");
        return savedManufacturers;
    }
    @PutMapping
    @CachePut(
            value = "manufacturer",
            key = "#manufacturer.idManufacturer",
            unless = "#result == null" // No almacenar en caché si el resultado es 'null'.
    )
    public Manufacturer updateManufacturer(@RequestBody Manufacturer manufacturer){
        long start = System.currentTimeMillis();
        Manufacturer existingManufacturer = manufacturerService.findManufacturerById(manufacturer.getIdManufacturer());
        if (existingManufacturer == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Fabricante no encontrado");
        }
        Manufacturer updateManufactuer = manufacturerService.updateManufactuer(manufacturer);
        long end = System.currentTimeMillis();
        System.out.println("Tiempo de respuesta para actualizar fabricante: " + (end - start) + " ms");
        return updateManufactuer;
    }
    @DeleteMapping
    @CacheEvict(
            value = "manufacturer",
            key = "#id"
    )
    public void deleteManufacturer(@RequestParam long id){
        long start = System.currentTimeMillis();
        manufacturerService.deleteManufacturer(id);
        long end = System.currentTimeMillis();
        System.out.println("Tiempo de respuesta para eliminar fabricante: " + (end - start) + " ms");
    }
}

