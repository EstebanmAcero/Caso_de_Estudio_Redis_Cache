package com.uptc.frw.casoestudioredis.controller;

import com.uptc.frw.casoestudioredis.jpa.model.ComponentRepair;
import com.uptc.frw.casoestudioredis.jpa.model.DeviceDetail;
import com.uptc.frw.casoestudioredis.services.ComponentRepairService;
import com.uptc.frw.casoestudioredis.services.DeviceDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador para gestionar las reparaciones de componentes.
 * Utiliza caché para mejorar el rendimiento de las operaciones CRUD.
 */

@RestController
@RequestMapping("componentRepair")
public class ComponentRepairController {
    @Autowired
    public ComponentRepairService componentRepairService;

    /**
     * Obtiene una lista de todas las reparaciones de componentes.
     * Los resultados se almacenan en caché para consultas futuras.
     * @return Lista de todas las reparaciones de componentes.
     */

    @GetMapping
    @Cacheable(
            value = "ComponentRepair",
            key = "'allComponentRepair'",
            unless = "#result == null"
    )
    public List<ComponentRepair> getAllComponentRepair(){
        return componentRepairService.findAllComponentRepair();
    }

    /**
     * Obtiene una reparación de componente específica por su ID.
     * Los resultados se almacenan en caché para reducir el tiempo de respuesta en futuras consultas.
     * @param id ID de la reparación de componente a buscar.
     * @return Reparación de componente correspondiente al ID proporcionado.
     */

    @GetMapping("{id}")
    @Cacheable(
            value = "ComponentRepair",
            key = "#id",
            unless = "#result == null"
    )

    public ComponentRepair getComponentRepair(@PathVariable long id){
        return componentRepairService.findByIdComponentRepo(id);
    }

    /**
     * Agrega una nueva reparación de componente.
     * Almacena el resultado en la caché para futuras consultas.
     * @param componentRepair Objeto ComponentRepair que se desea agregar.
     * @return Reparación de componente guardada en la base de datos.
     */

    @PostMapping
    @CachePut(
            value = "ComponentRepair",
            key = "#componentRepair.idComponentRepair",
            unless = "#result == null"
    )

        public ComponentRepair addComponentRepair(@RequestBody ComponentRepair componentRepair){
        return componentRepairService.saveComponentRep(componentRepair);
    }

    /**
     * Actualiza una reparación de componente existente.
     * El resultado actualizado se almacena en la caché para mantenerla sincronizada.
     * @param componentRepair Objeto ComponentRepair con los datos actualizados.
     * @return Reparación de componente actualizada.
     */

    @PutMapping
    @CachePut(
            value = "ComponentRepair",
            key = "#componentRepair.idComponentRepair",
            unless = "#result == null"
    )

    public ComponentRepair updateComponentRepair(@RequestBody ComponentRepair componentRepair){
        return componentRepairService.updateComponentRepair(componentRepair);
    }

    /**
     * Elimina una reparación de componente específica por su ID.
     * También elimina el resultado de la caché para mantener la coherencia.
     * @param id ID de la reparación de componente a eliminar.
     */

    @DeleteMapping
    @CacheEvict(
            value = "ComponentRepair",
            key = "#id"
    )

    public void deleteComponentRepair(@RequestParam long id){
        componentRepairService.deleteComponentRepair(id);
    }
}
