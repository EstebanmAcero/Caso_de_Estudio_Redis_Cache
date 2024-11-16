package com.uptc.frw.casoestudioredis.services;

import com.uptc.frw.casoestudioredis.jpa.model.*;
import com.uptc.frw.casoestudioredis.jpa.repository.ClientRepository;
import com.uptc.frw.casoestudioredis.jpa.repository.DeviceDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceDetailService {

    @Autowired
    private DeviceDetailRepository deviceDetailRepository;  // Repositorio para interactuar con la base de datos para detalles de dispositivos
    @Autowired
    private ElectronicDeviceService electronicDeviceService;  // Servicio para manejar la entidad ElectronicDevice (Dispositivo Electrónico)
    @Autowired
    private ComponentService componentService;  // Servicio para manejar la entidad Component (Componente)

    /**
     * Obtiene todos los detalles de los dispositivos de la base de datos.
     * @return lista de detalles de dispositivos
     */
    public List<DeviceDetail> findAllDeviceDetails() {
        return deviceDetailRepository.findAll();  // Devuelve todos los detalles de dispositivos usando el repositorio
    }

    /**
     * Busca un detalle de dispositivo por su ID.
     * @param id ID del detalle del dispositivo
     * @return el detalle del dispositivo encontrado o null si no existe
     */
    public DeviceDetail findByIdDeviceDetail(Long id){
        return deviceDetailRepository.findById(id).orElse(null);  // Busca el detalle de dispositivo por su ID
    }

    /**
     * Guarda un nuevo detalle de dispositivo en la base de datos.
     * @param deviceDetail el detalle del dispositivo a guardar
     * @return el detalle del dispositivo guardado
     */
    public DeviceDetail saveDeviceDetail(DeviceDetail deviceDetail){
        // Obtiene el dispositivo electrónico y componente relacionados por sus respectivos IDs
        ElectronicDevice electronicDevice = electronicDeviceService.findByIdElectronicDevice(deviceDetail.getIdElectronicDevice());
        Component component = componentService.findByIdComponent(deviceDetail.getIdComponent());

        // Establece las relaciones entre el detalle del dispositivo, el dispositivo electrónico y el componente
        deviceDetail.setElectronicDevice(electronicDevice);
        deviceDetail.setComponent(component);

        return deviceDetailRepository.save(deviceDetail);  // Guarda el detalle del dispositivo
    }

    /**
     * Actualiza un detalle de dispositivo existente en la base de datos.
     * @param deviceDetail el detalle del dispositivo con los nuevos valores
     * @return el detalle del dispositivo actualizado
     */
    public DeviceDetail updateDevClient(DeviceDetail deviceDetail){
        // Obtiene el dispositivo electrónico y componente relacionados por sus respectivos IDs
        ElectronicDevice electronicDevice = electronicDeviceService.findByIdElectronicDevice(deviceDetail.getIdElectronicDevice());
        Component component = componentService.findByIdComponent(deviceDetail.getIdComponent());

        // Encuentra el detalle del dispositivo existente
        DeviceDetail deviceDetail1 = findByIdDeviceDetail(deviceDetail.getIdDeviceDetail());

        // Actualiza los campos del detalle de dispositivo con los nuevos valores
        deviceDetail1.setQuantityDeviceDetail(deviceDetail.getQuantityDeviceDetail());
        deviceDetail1.setPriceDeviceDetail(deviceDetail.getPriceDeviceDetail());
        deviceDetail1.setComponent(component);
        deviceDetail1.setElectronicDevice(electronicDevice);

        return deviceDetailRepository.save(deviceDetail1);  // Guarda el detalle del dispositivo actualizado
    }

    /**
     * Elimina un detalle de dispositivo por su ID.
     * @param id el ID del detalle de dispositivo a eliminar
     */
    public void deleteDeviceDetail(long id){
        deviceDetailRepository.deleteById(id);  // Elimina el detalle del dispositivo por ID
    }
}
