package com.uptc.frw.casoestudioredis.services;

import com.uptc.frw.casoestudioredis.jpa.model.*;
import com.uptc.frw.casoestudioredis.jpa.repository.ComponentRepairRepository;
import com.uptc.frw.casoestudioredis.jpa.repository.ComponentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComponentRepairService {

    @Autowired
    private ComponentRepairRepository componentRepairRepository;  // Repositorio para ComponentRepair
    @Autowired
    private ComponentService componentService;  // Servicio para Component
    @Autowired
    private TypeElectronicDeviceService typeElectronicDeviceService;  // Servicio para TypeElectronicDevice (no usado en este servicio, pero inyectado)

    /**
     * Obtiene todos los componentes reparados de la base de datos.
     * @return lista de componentes reparados
     */
    public List<ComponentRepair> findAllComponentRepair() {
        return componentRepairRepository.findAll();  // Método de JpaRepository para obtener todos los ComponentRepair
    }

    /**
     * Busca un componente reparado por su ID.
     * @param id ID del componente reparado
     * @return el componente reparado encontrado o null si no existe
     */
    public ComponentRepair findByIdComponentRepo(Long id){
        return componentRepairRepository.findById(id).orElse(null);  // Busca el componente reparado por ID
    }

    /**
     * Guarda un componente reparado en la base de datos.
     * @param componentRepair componente reparado a guardar
     * @return el componente reparado guardado
     */
    public ComponentRepair saveComponentRep(ComponentRepair componentRepair){
        // Busca el componente asociado al componente reparado
        Component component = componentService.findByIdComponent(componentRepair.getIdComponent());
        // Establece la relación entre el componente reparado y el componente
        componentRepair.setComponentRepairKey(component);
        // Guarda el componente reparado
        return componentRepairRepository.save(componentRepair);
    }

    /**
     * Actualiza un componente reparado en la base de datos.
     * @param componentRepair componente reparado con datos actualizados
     * @return el componente reparado actualizado
     */
    public ComponentRepair updateComponentRepair(ComponentRepair componentRepair){
        // Busca el componente reparado por ID
        ComponentRepair componentRepair1 = findByIdComponentRepo(componentRepair.getIdComponent());
        // Actualiza la relación del componente reparado
        componentRepair1.setComponentRepairKey(componentRepair.getComponentRepairKey());
        // Guarda el componente reparado actualizado
        return componentRepairRepository.save(componentRepair1);
    }

    /**
     * Elimina un componente reparado por su ID.
     * @param id ID del componente reparado a eliminar
     */
    public void deleteComponentRepair(long id){
        componentRepairRepository.deleteById(id);  // Elimina el componente reparado por ID
    }
}
