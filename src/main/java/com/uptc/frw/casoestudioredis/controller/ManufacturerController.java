package com.uptc.frw.casoestudioredis.controller;

import com.uptc.frw.casoestudioredis.jpa.model.Manufacturer;
import com.uptc.frw.casoestudioredis.services.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("manufacturer")
public class ManufacturerController {
    @Autowired
    private ManufacturerService manufacturerService;
    @GetMapping
    public List<Manufacturer> getAllManufacturers() {
        return manufacturerService.findAllManufacturer();
    }
    @GetMapping("id")
    public Manufacturer getManufacturerById(@PathVariable long id) {
        return manufacturerService.findManufacturerById(id);
    }
    @PostMapping
    public Manufacturer addManufacturer(@RequestBody Manufacturer manufacturer){
        return manufacturerService.saveManufacturer(manufacturer);
    }
    @PutMapping
    public Manufacturer updateManufacturer(@RequestBody Manufacturer manufacturer){
        return manufacturerService.updateManufactuer(manufacturer);
    }
    @DeleteMapping
    public void deleteManufacturer(@RequestParam long id){
        manufacturerService.deleteManufacturer(id);
    }
}

