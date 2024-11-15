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

    /**
     * Controlador para la gestión de componentes electrónicos.
     * Utiliza caché para optimizar el rendimiento de las operaciones.
     */

    @Autowired
    public ComponentService componentService;

    /**
     * Obtiene todos los componentes electrónicos.
     * Este método no utiliza caché ya que devuelve una lista completa de componentes.
     * @return Lista de todos los componentes.
     */

    @GetMapping
    public List<Component> getAllComponents(){
        return componentService.findAllComponents();
    }

    /**
     * Obtiene un componente específico por su ID.
     * Los resultados se almacenan en la caché para reducir el tiempo de respuesta en búsquedas futuras.
     * @param id ID del componente a buscar.
     * @return Componente correspondiente al ID proporcionado.
     */

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

    /**
     * Agrega un nuevo componente electrónico.
     * Almacena el resultado en la caché para futuras consultas.
     * @param component Objeto Component que se desea agregar.
     * @return Componente que se ha guardado en la base de datos.
     */

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

    /**
     * Actualiza un componente existente.
     * Almacena el componente actualizado en la caché para mantener la sincronización.
     * @param component Objeto Component con los datos actualizados.
     * @return Componente que ha sido actualizado en la base de datos.
     */

    @PutMapping
    @CachePut(
            value = "components",
            key = "#components.idComponent",
            unless = "#result == null" // No almacenar en caché si el resultado es 'null'.
    )
    public Component updateComponent(@RequestBody Component component){
        long start = System.currentTimeMillis();
        // Verifica si el componente existe en la base de datos
        Component existingComponet =componentService.findByIdComponent(component.getIdComponent());
        if (existingComponet == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found");
        }
        // Actualiza el componente.
        Component updatedComponent = componentService.updateComponent(component);
        long end = System.currentTimeMillis();
        System.out.println("Tiempo de respuesta para actualizar cliente: " + (end - start) + " ms");
        return updatedComponent;
    }

    /**
     * Elimina un componente específico por su ID.
     * También elimina el componente de la caché para mantener la coherencia.
     * @param id ID del componente a eliminar.
     */

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
