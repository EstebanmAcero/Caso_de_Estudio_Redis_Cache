package com.uptc.frw.casoestudioredis.services;

import com.uptc.frw.casoestudioredis.jpa.model.Manufacturer;
import com.uptc.frw.casoestudioredis.jpa.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerService {
    @Autowired
    private ManufacturerRepository manufacturerRepository;
    public List<Manufacturer> findAllManufacturer(){
        return manufacturerRepository.findAll();
    }
    public Manufacturer findManufacturerById(Long id){
        return manufacturerRepository.findById(id).orElse(null);
    }
    public Manufacturer saveManufacturer(Manufacturer manufacturer){
        return manufacturerRepository.save(manufacturer);
    }
    public Manufacturer updateManufactuer(Manufacturer manufacturer){
        Manufacturer manufacturerUpdate = findManufacturerById(manufacturer.getIdManufacturer());
        manufacturerUpdate.setNameManufacturer(manufacturer.getNameManufacturer());
        manufacturerUpdate.setAddressManufacturer(manufacturer.getAddressManufacturer());
        manufacturerUpdate.setPhoneManufacturer(manufacturer.getPhoneManufacturer());
        manufacturerUpdate.setRifManufacturer(manufacturer.getRifManufacturer());
        manufacturerUpdate.setFiscalDomicileManufacturer(manufacturer.getFiscalDomicileManufacturer());
        return manufacturerRepository.save(manufacturerUpdate);
    }
    public void deleteManufacturer(long idManufacturer){
        manufacturerRepository.deleteById(idManufacturer);
    }
}