package com.uptc.frw.casoestudioredis.controller;

import com.uptc.frw.casoestudioredis.jpa.model.Client;
import com.uptc.frw.casoestudioredis.jpa.model.Component;
import com.uptc.frw.casoestudioredis.jpa.model.TypeElectronicDevice;
import com.uptc.frw.casoestudioredis.services.ComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("component")
public class ComponentController {
    @Autowired
    public ComponentService componentService;
    @GetMapping
    public List<Component> getAllComponents(){
        return componentService.findAllComponents();
    }
    @GetMapping("{id}")
    @Cacheable(                         // Cachea los resultados de búsqueda por ID
            value = "components",    // Nombre de la caché donde se almacena el resultado.
            key = "#id",          // Clave de la caché, en este caso el 'id' del componente.
            unless = "#result == null" // No almacenar en caché si el resultado es 'null'.
    )
    public Component getComponentById(@PathVariable long id){
        long start = System.currentTimeMillis();
        Component component = componentService.findByIdComponent(id);
        long end = System.currentTimeMillis();
        System.out.println("Tiempo de respuesta: " + (end - start) + " ms");
        return component;
    }
    @PostMapping
    @CachePut(
            value = "components",
            key = "#components.idComponent",
            unless = "#result == null" // No almacenar en caché si el resultado es 'null'.
    )
    public Component addComponent(@RequestBody Component component){
        long start = System.currentTimeMillis();
        Component saveComponent  = componentService.saveComponent(component);
        long end = System.currentTimeMillis();
        System.out.println("Tiempo de respuesta para agregar componente: " + (end - start) + " ms");
        return saveComponent;
    }
    @PutMapping
    @CachePut(
            value = "components",
            key = "#components.idComponent",
            unless = "#result == null" // No almacenar en caché si el resultado es 'null'.
    )
    public Component updateComponent(@RequestBody Component component){
        long start = System.currentTimeMillis();
        Component existingComponet =componentService.findByIdComponent(component.getIdComponent());
        if (existingComponet == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found");
        }
        Component updatedComponent = componentService.updateComponent(component);
        long end = System.currentTimeMillis();
        System.out.println("Tiempo de respuesta para actualizar cliente: " + (end - start) + " ms");
        return updatedComponent;
    }
    @DeleteMapping
    @CacheEvict(
            value = "components",
            key = "#id"
    )
    public void deleteComponent(@RequestParam long id){
        long start = System.currentTimeMillis();
        componentService.deleteComponent(id);
        long end = System.currentTimeMillis();
        System.out.println("Tiempo de respuesta para eliminar componente: " + (end - start) + " ms");
    }

}
