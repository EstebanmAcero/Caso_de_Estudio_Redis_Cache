package com.uptc.frw.casoestudioredis.controller;

import com.uptc.frw.casoestudioredis.jpa.model.Client;
import com.uptc.frw.casoestudioredis.jpa.model.TypeElectronicDevice;
import com.uptc.frw.casoestudioredis.services.TypeElectronicDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("typeDevice")
public class TypeElectronicDeviceController {
    @Autowired
    public TypeElectronicDeviceService typeElectronicDeviceService;
    @GetMapping
    public List<TypeElectronicDevice> getAllTypes(){
        return typeElectronicDeviceService.findAllTypes();
    }
    @GetMapping("{id}")
    public TypeElectronicDevice getTypeById(@PathVariable long id){
        return typeElectronicDeviceService.findByIdType(id);
    }
    @PostMapping
    public TypeElectronicDevice addType(@RequestBody TypeElectronicDevice typeElectronicDevice){
        return typeElectronicDeviceService.saveType(typeElectronicDevice);
    }
    @PutMapping
    public TypeElectronicDevice updateType(@RequestBody TypeElectronicDevice typeElectronicDevice){
        return typeElectronicDeviceService.updateType(typeElectronicDevice);
    }
    @DeleteMapping
    public void deleteType(@RequestParam long id){
        typeElectronicDeviceService.deleteType(id);
    }
}
