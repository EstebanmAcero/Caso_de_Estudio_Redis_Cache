package com.uptc.frw.casoestudioredis.controller;

import com.uptc.frw.casoestudioredis.jpa.model.Repair;
import com.uptc.frw.casoestudioredis.services.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador para gestionar las reparaciones.
 */
@RestController
@RequestMapping("repair")
public class RepairController {

    @Autowired
    public RepairService repairService;

    /**
     * Obtiene todas las reparaciones.
     *
     * @return Lista de reparaciones
     */
    @GetMapping
    @Cacheable(
            value = "Repairs",
            key = "'allRepairs'",
            unless = "#result == null"
    )
    public List<Repair> getAllRepairs() {
        return repairService.findAllRepair();
    }

    /**
     * Obtiene una reparación por su ID.
     *
     * @param id ID de la reparación
     * @return Reparación específica
     */
    @GetMapping("{id}")
    @Cacheable(
            value = "Repair",
            key = "#id",
            unless = "#result == null"
    )
    public Repair getRepairById(@PathVariable long id) {
        return repairService.findByIdRepair(id);
    }

    /**
     * Agrega una nueva reparación.
     *
     * @param repair Objeto de reparación a agregar
     * @return La reparación agregada
     */
    @PostMapping
    public Repair addRepair(@RequestBody Repair repair) {
        return repairService.saveRepair(repair);
    }

    /**
     * Actualiza una reparación existente.
     *
     * @param repair Objeto de reparación con los datos actualizados
     * @return La reparación actualizada
     */
    @PutMapping
    @CachePut(
            value = "Repair",
            key = "#repair.idRepair",
            unless = "#result == null"
    )
    public Repair updateRepair(@RequestBody Repair repair) {
        return repairService.updateRepair(repair);
    }

    /**
     * Elimina una reparación por su ID.
     *
     * @param id ID de la reparación a eliminar
     */
    @DeleteMapping
    @CacheEvict(
            value = "repair",
            key = "#id"
    )
    public void deleteRepair(@RequestParam long id) {
        repairService.deleteRepair(id);
    }
}
