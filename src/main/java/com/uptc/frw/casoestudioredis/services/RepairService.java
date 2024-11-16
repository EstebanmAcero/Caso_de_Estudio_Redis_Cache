package com.uptc.frw.casoestudioredis.services;

import com.uptc.frw.casoestudioredis.jpa.model.Client;
import com.uptc.frw.casoestudioredis.jpa.model.ElectronicDevice;
import com.uptc.frw.casoestudioredis.jpa.model.Repair;
import com.uptc.frw.casoestudioredis.jpa.repository.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepairService {

    @Autowired
    private RepairRepository repairRepository;  // Repositorio para interactuar con la base de datos de reparaciones

    @Autowired
    private ElectronicDeviceService electronicDeviceService;  // Servicio para manejar dispositivos electrónicos

    @Autowired
    private ClientService clientService;  // Servicio para manejar clientes

    /**
     * Obtiene todas las reparaciones desde la base de datos.
     * @return lista de todas las reparaciones
     */
    public List<Repair> findAllRepair() {
        return repairRepository.findAll();
    }

    /**
     * Busca una reparación por su ID.
     * @param id ID de la reparación a buscar
     * @return la reparación correspondiente, o null si no se encuentra
     */
    public Repair findByIdRepair(Long id){
        return repairRepository.findById(id).orElse(null);
    }

    /**
     * Guarda una nueva reparación en la base de datos.
     * @param repair la reparación a guardar
     * @return la reparación guardada
     */
    public Repair saveRepair(Repair repair){
        // Asocia cliente y dispositivo a la reparación antes de guardarla
        Client client = clientService.findByIdClient(repair.getIdClient());
        ElectronicDevice el = electronicDeviceService.findByIdElectronicDevice(repair.getIdElectronicDevice());

        repair.setClientRepair(client);  // Establece el cliente asociado
        repair.setElectronicDeviceRepair(el);  // Establece el dispositivo electrónico asociado

        return repairRepository.save(repair);  // Guarda la reparación en la base de datos
    }

    /**
     * Actualiza una reparación existente.
     * @param repair los nuevos datos de la reparación
     * @return la reparación actualizada
     */
    public Repair updateRepair(Repair repair){
        // Busca el cliente y dispositivo asociados a la reparación
        Client client = clientService.findByIdClient(repair.getIdClient());
        ElectronicDevice el = electronicDeviceService.findByIdElectronicDevice(repair.getIdElectronicDevice());

        // Busca la reparación existente y actualiza sus atributos
        Repair repairOld = findByIdRepair(repair.getIdRepair());
        repairOld.setDateInRepair(repair.getDateInRepair());
        repairOld.setDateOutRepair(repair.getDateOutRepair());
        repairOld.setDescriptionProblem(repair.getDescriptionProblem());
        repairOld.setClientRepair(client);
        repairOld.setElectronicDeviceRepair(el);

        return repairRepository.save(repairOld);  // Guarda la reparación actualizada
    }

    /**
     * Elimina una reparación de la base de datos.
     * @param id ID de la reparación a eliminar
     */
    public void deleteRepair(long id){
        repairRepository.deleteById(id);  // Elimina la reparación por su ID
    }
}
