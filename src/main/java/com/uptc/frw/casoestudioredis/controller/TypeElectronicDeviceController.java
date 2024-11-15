package com.uptc.frw.casoestudioredis.controller;

import com.uptc.frw.casoestudioredis.jpa.model.Client;
import com.uptc.frw.casoestudioredis.jpa.model.TypeElectronicDevice;
import com.uptc.frw.casoestudioredis.services.TypeElectronicDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador que maneja las solicitudes HTTP relacionadas con los tipos de dispositivos electrónicos.
 * Permite obtener, agregar, actualizar y eliminar tipos de dispositivos electrónicos, con soporte de almacenamiento en caché.
 */

@RestController
@RequestMapping("typeDevice")
public class TypeElectronicDeviceController {

    // Servicio utilizado para manejar la lógica de negocio relacionada con los tipos de dispositivos electrónicos
    @Autowired
    public TypeElectronicDeviceService typeElectronicDeviceService;

    /**
     * Obtiene todos los tipos de dispositivos electrónicos.
     * Los resultados se almacenan en caché para evitar consultas repetidas.
     *
     * @return Lista de todos los tipos de dispositivos electrónicos.
     */

    @GetMapping
    @Cacheable(
            value = "TypeElectronicDevice", // Nombre de la caché donde se almacenan los tipos de dispositivos
            key = "'allTypes'", // Clave de la caché, en este caso una clave fija 'allTypes'
            unless = "#result == null" // No almacenar en caché si el resultado es 'null
    )

    public List<TypeElectronicDevice> getAllTypes(){
        return typeElectronicDeviceService.findAllTypes();
    }

    /**
     * Obtiene un tipo de dispositivo electrónico por su ID.
     * Los resultados se almacenan en caché para evitar consultas repetidas.
     *
     * @param id El ID del tipo de dispositivo electrónico a buscar.
     * @return El tipo de dispositivo electrónico con el ID especificado.
     */

    @GetMapping("{id}")
    @Cacheable(
            value = "TypeElectronicDevice", // Caché donde se almacenan los resultados
            key = "#id", // Clave de la caché, en este caso el 'id' del tipo de dispositivo
            unless = "#result == null" // No almacenar en caché si el resultado es 'null'
    )

    public TypeElectronicDevice getTypeById(@PathVariable long id){
        return typeElectronicDeviceService.findByIdType(id);
    }

    /**
     * Agrega un nuevo tipo de dispositivo electrónico.
     *
     * @param typeElectronicDevice El tipo de dispositivo electrónico a agregar.
     * @return El tipo de dispositivo electrónico guardado.
     */

    @PostMapping

    public TypeElectronicDevice addType(@RequestBody TypeElectronicDevice typeElectronicDevice){
        return typeElectronicDeviceService.saveType(typeElectronicDevice);
    }

    /**
     * Actualiza un tipo de dispositivo electrónico existente.
     * El resultado se almacena en caché después de la actualización.
     *
     * @param typeElectronicDevice El tipo de dispositivo electrónico con los nuevos datos.
     * @return El tipo de dispositivo electrónico actualizado.
     */

    @PutMapping
    @CachePut(
            value = "TypeElectronicDevice",
            key = "#typeelectronicdevice.idtypeelectronicdevice",
            unless = "#result == null"
    )

    public TypeElectronicDevice updateType(@RequestBody TypeElectronicDevice typeElectronicDevice){
        return typeElectronicDeviceService.updateType(typeElectronicDevice);
    }

    @DeleteMapping
    @CacheEvict(
            value = "TypeElectronicDevice",
            key = "#id"
    )

    public void deleteType(@RequestParam long id){
        typeElectronicDeviceService.deleteType(id);
    }
}
