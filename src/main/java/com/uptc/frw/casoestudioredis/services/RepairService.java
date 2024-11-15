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
    private RepairRepository repairRepository;
    @Autowired
    private ElectronicDeviceService electronicDeviceService;
    @Autowired
    private ClientService clientService;

    public List<Repair> findAllRepair() {
        return repairRepository.findAll();
    }

    public Repair findByIdRepair(Long id){
        return repairRepository.findById(id).orElse(null);
    }

    public Repair saveRepair(Repair repair){
        Client client = clientService.findByIdClient(repair.getIdClient());
        ElectronicDevice el = electronicDeviceService.findByIdElectronicDevice(repair.getIdElectronicDevice());
        repair.setClientRepair(client);
        repair.setElectronicDeviceRepair(el);
        return repairRepository.save(repair);
    }

    public Repair updateRepair(Repair repair){
        Client client = clientService.findByIdClient(repair.getIdClient());
        ElectronicDevice el = electronicDeviceService.findByIdElectronicDevice(repair.getIdElectronicDevice());
        Repair repairOld= findByIdRepair(repair.getIdRepair());
        repair.setDateInRepair(repair.getDateInRepair());
        repair.setDateOutRepair(repair.getDateOutRepair());
        repair.setDescriptionProblem(repair.getDescriptionProblem());
        repair.setClientRepair(client);
        repair.setElectronicDeviceRepair(el);
        return repairRepository.save(repairOld);
    }

    public void deleteRepair(long id){
        repairRepository.deleteById(id);
    }
}


