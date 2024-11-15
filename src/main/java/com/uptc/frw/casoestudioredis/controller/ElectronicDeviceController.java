package com.uptc.frw.casoestudioredis.controller;

import com.uptc.frw.casoestudioredis.jpa.model.ElectronicDevice;
import com.uptc.frw.casoestudioredis.services.ElectronicDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador para gestionar dispositivos electrónicos.
 */
@RestController
@RequestMapping("elecDevice")
public class ElectronicDeviceController {

    @Autowired
    public ElectronicDeviceService electronicDeviceService;

    /**
     * Obtiene todos los dispositivos electrónicos.
     *
     * @return Lista de dispositivos electrónicos
     */
    @GetMapping
    @Cacheable(
            value = "ElectronicDevices",
            key = "'allElectronicDevice'",
            unless = "#result == null"
    )
    public List<ElectronicDevice> getAllElectronicDevice() {
        return electronicDeviceService.findAllElectronicDevices();
    }

    /**
     * Obtiene un dispositivo electrónico por su ID.
     *
     * @param id ID del dispositivo
     * @return Dispositivo electrónico
     */
    @GetMapping("{id}")
    @Cacheable(
            value = "ElectronicDevice",
            key = "#id",
            unless = "#result == null"
    )
    public ElectronicDevice getElectronicDevice(@PathVariable long id) {
        return electronicDeviceService.findByIdElectronicDevice(id);
    }

    /**
     * Agrega un nuevo dispositivo electrónico.
     *
     * @param electronicDevice Dispositivo electrónico a agregar
     * @return El dispositivo electrónico agregado
     */
    @PostMapping
    @CachePut(
            value = "ElectronicDevice",
            key = "#electronicDevice.idElectronicDevice",
            unless = "#result == null"
    )
    public ElectronicDevice addElectronicDevice(@RequestBody ElectronicDevice electronicDevice) {
        return electronicDeviceService.saveElectronicDevice(electronicDevice);
    }

    /**
     * Actualiza un dispositivo electrónico existente.
     *
     * @param electronicDevice Dispositivo electrónico con los datos actualizados
     * @return El dispositivo electrónico actualizado
     */
    @PutMapping
    @CachePut(
            value = "ElectronicDevice",
            key = "#electronicDevice.idElectronicDevice",
            unless = "#result == null"
    )
    public ElectronicDevice updateElectronicDevice(@RequestBody ElectronicDevice electronicDevice) {
        return electronicDeviceService.updateElectronicDevice(electronicDevice);
    }

    /**
     * Elimina un dispositivo electrónico por su ID.
     *
     * @param id ID del dispositivo a eliminar
     */
    @DeleteMapping
    @CacheEvict(
            value = "ElectronicDevice",
            key = "#id"
    )
    public void deleteElectronicDevice(@RequestParam long id) {
        electronicDeviceService.deleteelEctronicDevice(id);
    }
}
