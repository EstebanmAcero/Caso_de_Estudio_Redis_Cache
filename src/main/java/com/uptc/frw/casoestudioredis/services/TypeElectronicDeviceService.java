package com.uptc.frw.casoestudioredis.services;

import com.uptc.frw.casoestudioredis.jpa.model.TypeElectronicDevice;
import com.uptc.frw.casoestudioredis.jpa.repository.TypeElectronicDeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeElectronicDeviceService {
    @Autowired
    private TypeElectronicDeviceRepository  typeElectronicDeviceRepository;

    public List<TypeElectronicDevice> findAllTypes() {
        return typeElectronicDeviceRepository.findAll();
    }
    public TypeElectronicDevice findByIdType(Long id){
        return typeElectronicDeviceRepository.findById(id).orElse(null);
    }
    public TypeElectronicDevice saveType(TypeElectronicDevice type){
        return typeElectronicDeviceRepository.save(type);
    }
    public TypeElectronicDevice updateType(TypeElectronicDevice type){
        TypeElectronicDevice typeold= findByIdType(type.getIdTypeElectronicDevice());

        typeold.setNameElectronicDevice(type.getNameElectronicDevice());
        typeold.setCharacteristicsElectronicDevice(type.getCharacteristicsElectronicDevice());
        typeold.setTypeElectronicDevice(type.getTypeElectronicDevice());

        return typeElectronicDeviceRepository.save(typeold);
    }
    public void deleteType(long id){
        typeElectronicDeviceRepository.deleteById(id);
    }

}
