package com.uptc.frw.casoestudioredis.controller;

import com.uptc.frw.casoestudioredis.jpa.model.Component;
import com.uptc.frw.casoestudioredis.jpa.model.TypeElectronicDevice;
import com.uptc.frw.casoestudioredis.services.ComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("component")
public class ComponentController {
    @Autowired
    public ComponentService componentService;
    @GetMapping
    public List<Component> getAllComponents(){
        return componentService.findAllComponents();
    }
    @GetMapping("{id}")
    public Component getComponentById(@PathVariable long id){
        return componentService.findByIdComponent(id);
    }
    @PostMapping
    public Component addComponent(@RequestBody Component component){
        return componentService.saveComponent(component);
    }
    @PutMapping
    public Component updateComponent(@RequestBody Component component){
        return componentService.updateComponent(component);
    }
    @DeleteMapping
    public void deleteComponent(@RequestParam long id){
        componentService.deleteComponent(id);
    }

}
