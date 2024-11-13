package com.uptc.frw.casoestudioredis.services;

import com.uptc.frw.casoestudioredis.jpa.model.Client;
import com.uptc.frw.casoestudioredis.jpa.model.ElectronicDevice;
import com.uptc.frw.casoestudioredis.jpa.repository.ClientRepository;
import com.uptc.frw.casoestudioredis.jpa.repository.ElectronicDeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElectronicDeviceService {
    @Autowired
    private ElectronicDeviceRepository electronicDeviceRepository;

    public List<ElectronicDevice> findAllElectronicDevices() {
        return electronicDeviceRepository.findAll();
    }
    public ElectronicDevice findByIdElectronicDevice(Long id){
        return electronicDeviceRepository.findById(id).orElse(null);
    }

    public ElectronicDevice saveElectronicDevice(ElectronicDevice electronicDevice){
        return electronicDeviceRepository.save(electronicDevice);
    }
    public ElectronicDevice updateElectronicDevice(ElectronicDevice electronicDevice){
        ElectronicDevice electronicDevice1 = findByIdElectronicDevice(electronicDevice.getIdElectronicDevice());
        electronicDevice1.setDescriptionElectronicDevice(electronicDevice.getDescriptionElectronicDevice());
        return electronicDeviceRepository.save(electronicDevice1);
    }
    public void deleteelEctronicDevice(long id){
        electronicDeviceRepository.deleteById(id);
    }
}
