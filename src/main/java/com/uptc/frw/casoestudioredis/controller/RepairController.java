package com.uptc.frw.casoestudioredis.controller;

import com.uptc.frw.casoestudioredis.jpa.model.Repair;
import com.uptc.frw.casoestudioredis.services.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("repair")
public class RepairController {
    @Autowired
    public RepairService repairService;
    @GetMapping
    public List<Repair> getAllRepairs() {
        return repairService.findAllRepair();
    }
    @GetMapping("{id}")
    public Repair getRepairById(@PathVariable long id){
        return repairService.findByIdRepair(id);
    }
    @PostMapping
    public Repair addRepair(@RequestBody Repair repair){
        return repairService.saveRepair(repair);
    }
    @PutMapping
    public Repair updateRepair(@RequestBody Repair repair){
        return repairService.updateRepair(repair);
    }
    @DeleteMapping
    public void deleteRepair(@RequestParam long id){
        repairService.deleteRepair(id);
    }
}

