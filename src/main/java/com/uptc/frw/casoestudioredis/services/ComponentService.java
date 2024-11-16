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
    private ComponentRepository componentRepository;  // Repositorio para interactuar con la base de datos para componentes
    @Autowired
    private ManufacturerService manufacturerService;  // Servicio para manejar la entidad Manufacturer (Fabricante)

    /**
     * Obtiene todos los componentes de la base de datos.
     * @return lista de componentes
     */
    public List<Component> findAllComponents() {
        return componentRepository.findAll();  // Devuelve todos los componentes usando el repositorio
    }

    /**
     * Busca un componente por su ID.
     * @param id ID del componente
     * @return el componente encontrado o null si no existe
     */
    public Component findByIdComponent(Long id){
        System.out.println("Encontrando componente de la DB con ID : " + id);
        return componentRepository.findById(id).orElse(null);  // Busca el componente por su ID
    }

    /**
     * Guarda un nuevo componente en la base de datos.
     * @param component el componente a guardar
     * @return el componente guardado
     */
    public Component saveComponent(Component component){
        Manufacturer manufacturer = manufacturerService.findManufacturerById(component.getIdManufacturer());  // Busca el fabricante asociado
        System.out.println("Guardando Componente" + component.getNameComponent());
        component.setManufacturer(manufacturer);  // Establece el fabricante en el componente
        return componentRepository.save(component);  // Guarda el componente
    }

    /**
     * Actualiza un componente existente en la base de datos.
     * @param component el componente con los nuevos valores
     * @return el componente actualizado
     */
    public Component updateComponent(Component component){
        Component component1 = findByIdComponent(component.getIdComponent());  // Encuentra el componente existente
        // Actualiza los campos del componente con los nuevos valores
        component1.setNameComponent(component.getNameComponent());
        component1.setDescriptionComponent(component.getDescriptionComponent());
        component1.setManufacturer(component.getManufacturer());
        System.out.println("Actualizando componente" + component1.getNameComponent());
        return componentRepository.save(component1);  // Guarda el componente actualizado
    }

    /**
     * Elimina un componente por su ID.
     * @param id el ID del componente a eliminar
     */
    public void deleteComponent(long id){
        System.out.println("Se ha eliminado el componente con ID " + id);
        componentRepository.deleteById(id);  // Elimina el componente por ID
    }
}
