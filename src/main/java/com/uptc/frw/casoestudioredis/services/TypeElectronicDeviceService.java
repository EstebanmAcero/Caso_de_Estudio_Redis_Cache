package com.uptc.frw.casoestudioredis.services;

import com.uptc.frw.casoestudioredis.jpa.model.TypeElectronicDevice;
import com.uptc.frw.casoestudioredis.jpa.repository.TypeElectronicDeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeElectronicDeviceService {

    @Autowired
    private TypeElectronicDeviceRepository typeElectronicDeviceRepository;  // Repositorio para manejar la persistencia de los tipos de dispositivos electrónicos

    /**
     * Obtiene todos los tipos de dispositivos electrónicos desde la base de datos.
     * @return lista de todos los tipos de dispositivos electrónicos
     */
    public List<TypeElectronicDevice> findAllTypes() {
        return typeElectronicDeviceRepository.findAll();  // Devuelve todos los tipos de dispositivos electrónicos
    }

    /**
     * Busca un tipo de dispositivo electrónico por su ID.
     * @param id el ID del tipo de dispositivo
     * @return el tipo de dispositivo correspondiente o null si no se encuentra
     */
    public TypeElectronicDevice findByIdType(Long id){
        return typeElectronicDeviceRepository.findById(id).orElse(null);  // Devuelve el tipo de dispositivo encontrado o null si no existe
    }

    /**
     * Guarda un nuevo tipo de dispositivo electrónico en la base de datos.
     * @param type el tipo de dispositivo a guardar
     * @return el tipo de dispositivo guardado
     */
    public TypeElectronicDevice saveType(TypeElectronicDevice type){
        return typeElectronicDeviceRepository.save(type);  // Guarda y retorna el tipo de dispositivo
    }

    /**
     * Actualiza un tipo de dispositivo electrónico existente.
     * @param type los nuevos datos del tipo de dispositivo
     * @return el tipo de dispositivo actualizado
     */
    public TypeElectronicDevice updateType(TypeElectronicDevice type){
        // Busca el tipo de dispositivo a actualizar
        TypeElectronicDevice typeold = findByIdType(type.getIdTypeElectronicDevice());

        // Actualiza los atributos del tipo de dispositivo
        typeold.setNameElectronicDevice(type.getNameElectronicDevice());
        typeold.setCharacteristicsElectronicDevice(type.getCharacteristicsElectronicDevice());
        typeold.setTypeElectronicDevice(type.getTypeElectronicDevice());

        return typeElectronicDeviceRepository.save(typeold);  // Guarda y retorna el tipo de dispositivo actualizado
    }

    /**
     * Elimina un tipo de dispositivo electrónico por su ID.
     * @param id el ID del tipo de dispositivo a eliminar
     */
    public void deleteType(long id){
        typeElectronicDeviceRepository.deleteById(id);  // Elimina el tipo de dispositivo por su ID
    }
}
