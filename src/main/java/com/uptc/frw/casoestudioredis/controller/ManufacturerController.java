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

/**
 * Controlador que maneja las solicitudes HTTP para la entidad Manufacturer.
 * Contiene métodos para obtener, agregar, actualizar y eliminar fabricantes,
 * con soporte de almacenamiento en caché.
 */

@RestController
@RequestMapping("manufacturer")
public class ManufacturerController {

    // Servicio utilizado para manejar la lógica de negocio relacionada con los fabricantes.
    @Autowired
    private ManufacturerService manufacturerService;

    /**
     * Obtiene todos los fabricantes.
     *
     * @return Lista de todos los fabricantes.
     */

    @GetMapping
    public List<Manufacturer> getAllManufacturers() {
        return manufacturerService.findAllManufacturer();
    }

    /**
     * Obtiene un fabricante por su ID.
     * El resultado de la búsqueda se almacena en caché para evitar consultas repetidas.
     *
     * @param id El ID del fabricante a buscar.
     * @return El fabricante con el ID especificado.
     */

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

    /**
     * Agrega un nuevo fabricante.
     * El resultado se almacena en caché después de agregarlo.
     *
     * @param manufacturer El fabricante a agregar.
     * @return El fabricante guardado.
     */

    @PostMapping
    @CachePut(
            value = "manufacturer", // Caché donde se almacena el nuevo fabricante
            key = "#manufacturer.idManufacturer", // Clave de la caché, en este caso el ID del fabricante
            unless = "#result == null" // No almacenar en caché si el resultado es 'null'.
    )
    public Manufacturer addManufacturer(@RequestBody Manufacturer manufacturer){
        long start = System.currentTimeMillis();
        Manufacturer saveManufacturer  = manufacturerService.saveManufacturer(manufacturer);
        long end = System.currentTimeMillis();
        System.out.println("Tiempo de respuesta para agregar fabricante: " + (end - start) + " ms");
        return saveManufacturer;
    }

    /**
     * Agrega múltiples fabricantes a la vez.
     *
     * @param manufacturers Lista de fabricantes a agregar.
     * @return Lista de fabricantes guardados.
     */

    @PostMapping("/generate")
    public List<Manufacturer> addMultipleManufacturers(@RequestBody List<Manufacturer> manufacturers) {
        long start = System.currentTimeMillis();
        List<Manufacturer> savedManufacturers = manufacturerService.saveAllManufacturers(manufacturers);
        long end = System.currentTimeMillis();
        System.out.println("Tiempo de respuesta para agregar múltiples fabricantes: " + (end - start) + " ms");
        return savedManufacturers;
    }

    /**
     * Actualiza un fabricante existente.
     * Si el fabricante no existe, lanza una excepción con el estado HTTP 404.
     * El resultado se almacena en caché después de la actualización.
     *
     * @param manufacturer El fabricante con los nuevos datos.
     * @return El fabricante actualizado.
     */

    @PutMapping
    @CachePut(
            value = "manufacturer",
            key = "#manufacturer.idManufacturer",
            unless = "#result == null" // No almacenar en caché si el resultado es 'null'.
    )
    public Manufacturer updateManufacturer(@RequestBody Manufacturer manufacturer){
        long start = System.currentTimeMillis();
        Manufacturer existingManufacturer = manufacturerService.findManufacturerById(manufacturer.getIdManufacturer());
        // Si el fabricante no existe, se lanza una excepción
        if (existingManufacturer == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Fabricante no encontrado");
        }
        Manufacturer updateManufactuer = manufacturerService.updateManufactuer(manufacturer);
        long end = System.currentTimeMillis();
        System.out.println("Tiempo de respuesta para actualizar fabricante: " + (end - start) + " ms");
        return updateManufactuer;
    }

    /**
     * Elimina un fabricante por su ID.
     * Después de eliminarlo, la caché correspondiente se limpia.
     *
     * @param id El ID del fabricante a eliminar.
     */

    @DeleteMapping
    @CacheEvict(
            value = "manufacturer", // Nombre de la caché donde se almacena el fabricante
            key = "#id" // Clave de la caché, en este caso el ID del fabricante
    )
    public void deleteManufacturer(@RequestParam long id){
        long start = System.currentTimeMillis();
        manufacturerService.deleteManufacturer(id);
        long end = System.currentTimeMillis();
        System.out.println("Tiempo de respuesta para eliminar fabricante: " + (end - start) + " ms");
    }
}

