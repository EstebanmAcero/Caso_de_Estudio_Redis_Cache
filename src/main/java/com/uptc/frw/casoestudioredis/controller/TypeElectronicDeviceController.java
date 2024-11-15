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

@RestController
@RequestMapping("typeDevice")
public class TypeElectronicDeviceController {
    @Autowired
    public TypeElectronicDeviceService typeElectronicDeviceService;

    @GetMapping
    @Cacheable(
            value = "TypeElectronicDevice",
            key = "'allTypes'",
            unless = "#result == null"
    )

    public List<TypeElectronicDevice> getAllTypes(){
        return typeElectronicDeviceService.findAllTypes();
    }

    @GetMapping("{id}")
    @Cacheable(
            value = "TypeElectronicDevice",
            key = "#id",
            unless = "#result == null"
    )

    public TypeElectronicDevice getTypeById(@PathVariable long id){
        return typeElectronicDeviceService.findByIdType(id);
    }

    @PostMapping

    public TypeElectronicDevice addType(@RequestBody TypeElectronicDevice typeElectronicDevice){
        return typeElectronicDeviceService.saveType(typeElectronicDevice);
    }

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
