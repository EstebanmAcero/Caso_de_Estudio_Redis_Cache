package com.uptc.frw.casoestudioredis.services;

import com.uptc.frw.casoestudioredis.jpa.model.Repair;
import com.uptc.frw.casoestudioredis.jpa.repository.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepairService {
    @Autowired
    private RepairRepository repairRepository;

    public List<Repair> findAllRepair() {
        return repairRepository.findAll();
    }

    public Repair findByIdRepair(Long id){
        return repairRepository.findById(id).orElse(null);
    }

    public Repair saveRepair(Repair repair){
        return repairRepository.save(repair);
    }

    public Repair updateRepair(Repair repair){
        Repair repairOld= findByIdRepair(repair.getIdRepair());
        repairOld.setDateInRepair(repair.getDateInRepair());
        repairOld.setDateOutRepair(repair.getDateOutRepair());
        repairOld.setDescriptionProblem(repair.getDescriptionProblem());
        return repairRepository.save(repairOld);
    }

    public void deleteRepair(long id){
        repairRepository.deleteById(id);
    }
}


