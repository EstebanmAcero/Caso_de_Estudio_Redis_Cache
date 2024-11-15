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
        System.out.println("Encontrando componente de la DB con ID : " + id);
        return componentRepository.findById(id).orElse(null);
    }
    public Component saveComponent(Component component){
        Manufacturer manufacturer = manufacturerService.findManufacturerById(component.getIdManufacturer());
        System.out.println("Guardando Componente" +component.getNameComponent());
        component.setManufacturer(manufacturer);
        return componentRepository.save(component);
    }
    public Component updateComponent(Component component){
        Component component1= findByIdComponent(component.getIdComponent());
        component1.setNameComponent(component.getNameComponent());
        component1.setDescriptionComponent(component.getDescriptionComponent());
        component1.setDescriptionComponent(component.getDescriptionComponent());
        component1.setManufacturer(component.getManufacturer());
        System.out.println("Actualizando componente" +component1.getNameComponent());
        return componentRepository.save(component1);
    }
    public void deleteComponent(long id){
        System.out.println("Se ha eliminado el componente con ID " + id);
        componentRepository.deleteById(id);
    }
}
