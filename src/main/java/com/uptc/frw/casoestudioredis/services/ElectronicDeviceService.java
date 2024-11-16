package com.uptc.frw.casoestudioredis.services;

import com.uptc.frw.casoestudioredis.jpa.model.Client;
import com.uptc.frw.casoestudioredis.jpa.model.ElectronicDevice;
import com.uptc.frw.casoestudioredis.jpa.model.TypeElectronicDevice;
import com.uptc.frw.casoestudioredis.jpa.repository.ClientRepository;
import com.uptc.frw.casoestudioredis.jpa.repository.ElectronicDeviceRepository;
import com.uptc.frw.casoestudioredis.jpa.repository.TypeElectronicDeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElectronicDeviceService {

    @Autowired
    private ElectronicDeviceRepository electronicDeviceRepository;  // Repositorio para interactuar con la base de datos de dispositivos electrónicos

    @Autowired
    private TypeElectronicDeviceService typeElectronicDevice;  // Servicio para manejar la entidad TypeElectronicDevice (Tipo de dispositivo electrónico)

    /**
     * Obtiene todos los dispositivos electrónicos almacenados en la base de datos.
     * @return lista de dispositivos electrónicos
     */
    public List<ElectronicDevice> findAllElectronicDevices() {
        return electronicDeviceRepository.findAll();  // Devuelve todos los dispositivos electrónicos usando el repositorio
    }

    /**
     * Busca un dispositivo electrónico por su ID.
     * @param id ID del dispositivo electrónico
     * @return el dispositivo electrónico encontrado o null si no existe
     */
    public ElectronicDevice findByIdElectronicDevice(Long id){
        return electronicDeviceRepository.findById(id).orElse(null);  // Busca el dispositivo electrónico por su ID
    }

    /**
     * Guarda un nuevo dispositivo electrónico en la base de datos.
     * @param electronicDevice el dispositivo electrónico a guardar
     * @return el dispositivo electrónico guardado
     */
    public ElectronicDevice saveElectronicDevice(ElectronicDevice electronicDevice){
        // Busca el tipo de dispositivo electrónico y lo establece en el dispositivo
        TypeElectronicDevice tds = typeElectronicDevice.findByIdType(electronicDevice.getIdTypeElectronicDevice());
        electronicDevice.setTypeElectronicDevice(tds);

        return electronicDeviceRepository.save(electronicDevice);  // Guarda el dispositivo electrónico
    }

    /**
     * Actualiza un dispositivo electrónico existente en la base de datos.
     * @param electronicDevice el dispositivo electrónico con los nuevos valores
     * @return el dispositivo electrónico actualizado
     */
    public ElectronicDevice updateElectronicDevice(ElectronicDevice electronicDevice){
        // Busca el tipo de dispositivo electrónico y lo establece en el dispositivo
        TypeElectronicDevice tds = typeElectronicDevice.findByIdType(electronicDevice.getIdTypeElectronicDevice());

        // Encuentra el dispositivo electrónico existente
        ElectronicDevice electronicDevice1 = findByIdElectronicDevice(electronicDevice.getIdElectronicDevice());

        // Actualiza los campos del dispositivo electrónico
        electronicDevice1.setDescriptionElectronicDevice(electronicDevice.getDescriptionElectronicDevice());
        electronicDevice1.setTypeElectronicDevice(tds);

        return electronicDeviceRepository.save(electronicDevice1);  // Guarda el dispositivo electrónico actualizado
    }

    /**
     * Elimina un dispositivo electrónico por su ID.
     * @param id el ID del dispositivo electrónico a eliminar
     */
    public void deleteelEctronicDevice(long id){
        electronicDeviceRepository.deleteById(id);  // Elimina el dispositivo electrónico por ID
    }
}
