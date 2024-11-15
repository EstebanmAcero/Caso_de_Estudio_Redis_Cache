package com.uptc.frw.casoestudioredis.controller;

import com.uptc.frw.casoestudioredis.jpa.model.Client;
import com.uptc.frw.casoestudioredis.jpa.model.DeviceDetail;
import com.uptc.frw.casoestudioredis.services.ClientService;
import com.uptc.frw.casoestudioredis.services.DeviceDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador para gestionar los detalles de dispositivos.
 * Utiliza caché para optimizar las operaciones CRUD y mejorar el rendimiento.
 */

@RestController
@RequestMapping("devDetail")
public class DeviceDetailController {
    @Autowired
    public DeviceDetailService deviceDetailService;

    /**
     * Obtiene una lista de todos los detalles de dispositivos.
     * Los resultados se almacenan en caché para acelerar futuras consultas.
     * @return Lista de todos los detalles de dispositivos.
     */

    @GetMapping
    @Cacheable(
            value = "DeviceDetail", // Nombre de la caché
            key = "'allDeviceDetail'", // Clave fija para identificar esta consulta
            unless = "#result == null" // No almacenar en caché si el resultado es nulo
    )

    public List<DeviceDetail> getAllDeviceDetails(){
        return deviceDetailService.findAllDeviceDetails();
    }

    /**
     * Obtiene un detalle de dispositivo específico por su ID.
     * Los resultados se almacenan en caché para mejorar el tiempo de respuesta.
     * @param id ID del detalle de dispositivo a buscar.
     * @return Detalle de dispositivo correspondiente al ID proporcionado.
     */

    @GetMapping("{id}")
    @Cacheable(
            value = "DeviceDetail", // Nombre de la caché
            key = "#id", // Clave basada en el ID del detalle del dispositivo
            unless = "#result == null" // No almacenar en caché si el resultado es nulo
    )

    public DeviceDetail getDeviceDetail(@PathVariable long id){
        return deviceDetailService.findByIdDeviceDetail(id);
    }

    /**
     * Agrega un nuevo detalle de dispositivo.
     * Este método no utiliza caché, ya que el dato se crea directamente.
     * @param deviceDetail Objeto DeviceDetail que se desea agregar.
     * @return Detalle de dispositivo guardado en la base de datos.
     */

    @PostMapping
    public DeviceDetail addDeviceDetail(@RequestBody DeviceDetail deviceDetail){
        return deviceDetailService.saveDeviceDetail(deviceDetail);
    }

    /**
     * Actualiza un detalle de dispositivo existente.
     * El resultado actualizado se almacena en la caché para mantenerla sincronizada.
     * @param deviceDetail Objeto DeviceDetail con los datos actualizados.
     * @return Detalle de dispositivo actualizado.
     */

    @PutMapping
    @CachePut(
            value = "DeviceDetail", // Nombre de la caché
            key = "#devicedetail.iddevicedetail", // Clave basada en el ID del detalle del dispositivo actualizado
            unless = "#result == null" // No almacenar en caché si el resultado es nulo
    )

    public DeviceDetail updateDeviceDetail(@RequestBody DeviceDetail deviceDetail){
        return deviceDetailService.updateDevClient(deviceDetail);
    }

    /**
     * Elimina un detalle de dispositivo específico por su ID.
     * También elimina el resultado de la caché para mantener la coherencia.
     * @param id ID del detalle de dispositivo a eliminar.
     */

    @DeleteMapping
    @CacheEvict(
            value = "DeviceDetail", // Nombre de la caché
            key = "#id" // Clave basada en el ID del detalle del dispositivo que se eliminará
    )

    public void deleteDeviceService(@RequestParam long id){
        deviceDetailService.deleteDeviceDetail(id);
    }
}
