package com.uptc.frw.casoestudioredis.controller;

import com.uptc.frw.casoestudioredis.jpa.model.Client;
import com.uptc.frw.casoestudioredis.jpa.model.ElectronicDevice;
import com.uptc.frw.casoestudioredis.services.ClientService;
import com.uptc.frw.casoestudioredis.services.ElectronicDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("elecDevice")
public class ElectronicDeviceController {
    @Autowired
    public ElectronicDeviceService electronicDeviceService;

    @GetMapping
    public List<ElectronicDevice> getAllElectronicDevice(){
        return electronicDeviceService.findAllElectronicDevices();
    }
    @GetMapping("{id}")
    public ElectronicDevice getElectronicDevice(@PathVariable long id){
        return electronicDeviceService.findByIdElectronicDevice(id);
    }
    @PostMapping
    public ElectronicDevice addElectronicDevice(@RequestBody ElectronicDevice electronicDevice){
        return electronicDeviceService.saveElectronicDevice(electronicDevice);
    }
    @PutMapping
    public ElectronicDevice updateElectronicDevice(@RequestBody ElectronicDevice electronicDevice){
        return electronicDeviceService.updateElectronicDevice(electronicDevice);
    }
    @DeleteMapping
    public void deleteElectronicDevice(@RequestParam long id){
        electronicDeviceService.deleteelEctronicDevice(id);
    }
}
