package com.uptc.frw.casoestudioredis.services;

import com.uptc.frw.casoestudioredis.jpa.model.Client;
import com.uptc.frw.casoestudioredis.jpa.model.Component;
import com.uptc.frw.casoestudioredis.jpa.model.Manufacturer;
import com.uptc.frw.casoestudioredis.jpa.repository.ComponentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComponentService {
    @Autowired
    private ComponentRepository componentRepository;
    @Autowired
    private ManufacturerService manufacturerService;

    public List<Component> findAllComponents() {
        return componentRepository.findAll();
    }
    public Component findByIdComponent(Long id){
        return componentRepository.findById(id).orElse(null);
    }
    public Component saveComponent(Component component){
        Manufacturer manufacturer = manufacturerService.findManufacturerById(component.getIdManufacturer());
        component.setManufacturer(manufacturer);
        return componentRepository.save(component);
    }
    public Component updateComponent(Component component){
        Component component1= findByIdComponent(component.getIdComponent());
        component1.setNameComponent(component.getNameComponent());
        component1.setDescriptionComponent(component.getDescriptionComponent());
        component1.setDescriptionComponent(component.getDescriptionComponent());
        component1.setManufacturer(component.getManufacturer());

        return componentRepository.save(component1);
    }
    public void deleteComponent(long id){
        componentRepository.deleteById(id);
    }
}
