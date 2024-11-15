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

@RestController
@RequestMapping("componentRepair")
public class ComponentRepairController {
    @Autowired
    public ComponentRepairService componentRepairService;

    @GetMapping
    @Cacheable(
            value = "ComponentRepair",
            key = "'allComponentRepair'",
            unless = "#result == null"
    )
    public List<ComponentRepair> getAllComponentRepair(){
        return componentRepairService.findAllComponentRepair();
    }

    @GetMapping("{id}")
    @Cacheable(
            value = "ComponentRepair",
            key = "#id",
            unless = "#result == null"
    )

    public ComponentRepair getComponentRepair(@PathVariable long id){
        return componentRepairService.findByIdComponentRepo(id);
    }


    @PostMapping
    @CachePut(
            value = "ComponentRepair",
            key = "#componentRepair.idComponentRepair",
            unless = "#result == null"
    )

        public ComponentRepair addComponentRepair(@RequestBody ComponentRepair componentRepair){
        return componentRepairService.saveComponentRep(componentRepair);
    }

    @PutMapping
    @CachePut(
            value = "ComponentRepair",
            key = "#componentRepair.idComponentRepair",
            unless = "#result == null"
    )

    public ComponentRepair updateComponentRepair(@RequestBody ComponentRepair componentRepair){
        return componentRepairService.updateComponentRepair(componentRepair);
    }

    @DeleteMapping
    @CacheEvict(
            value = "ComponentRepair",
            key = "#id"
    )

    public void deleteComponentRepair(@RequestParam long id){
        componentRepairService.deleteComponentRepair(id);
    }
}
