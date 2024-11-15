package com.uptc.frw.casoestudioredis.services;

import com.uptc.frw.casoestudioredis.jpa.model.*;
import com.uptc.frw.casoestudioredis.jpa.repository.ClientRepository;
import com.uptc.frw.casoestudioredis.jpa.repository.ComponentRepairRepository;
import com.uptc.frw.casoestudioredis.jpa.repository.ComponentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComponentRepairService {

    @Autowired
    private ComponentRepairRepository componentRepairRepository;
    @Autowired
    private ComponentService componentService;
    @Autowired
    private TypeElectronicDeviceService typeElectronicDeviceService;

    public List<ComponentRepair> findAllComponentRepair() {
        return componentRepairRepository.findAll();
    }
    public ComponentRepair findByIdComponentRepo(Long id){
        return componentRepairRepository.findById(id).orElse(null);
    }
    public ComponentRepair saveComponentRep(ComponentRepair componentRepair){
        Component component = componentService.findByIdComponent(componentRepair.getIdComponent());
        componentRepair.setComponentRepairKey(component);
        return componentRepairRepository.save(componentRepair);
    }
    public ComponentRepair updateComponentRepair(ComponentRepair componentRepair){
        ComponentRepair componentRepair1 = findByIdComponentRepo(componentRepair.getIdComponent());
        componentRepair1.setComponentRepairKey(componentRepair.getComponentRepairKey());
        return componentRepairRepository.save(componentRepair1);
    }

    public void deleteComponentRepair(long id){
        componentRepairRepository.deleteById(id);
    }
}
