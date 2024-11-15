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
    private DeviceDetailRepository deviceDetailRepository;
    @Autowired
    private ElectronicDeviceService electronicDeviceService;
    @Autowired
    private ComponentService componentService;

    public List<DeviceDetail> findAllDeviceDetails() {
        return deviceDetailRepository.findAll();
    }
    public DeviceDetail findByIdDeviceDetail(Long id){
        return deviceDetailRepository.findById(id).orElse(null);
    }
    public DeviceDetail saveDeviceDetail(DeviceDetail deviceDetail){
        ElectronicDevice electronicDevice = electronicDeviceService.findByIdElectronicDevice(deviceDetail.getIdElectronicDevice());
        Component component = componentService.findByIdComponent(deviceDetail.getIdComponent());
        deviceDetail.setElectronicDevice(electronicDevice);
        deviceDetail.setComponent(component);
        return deviceDetailRepository.save(deviceDetail);
    }

    public DeviceDetail updateDevClient(DeviceDetail deviceDetail){
        ElectronicDevice electronicDevice = electronicDeviceService.findByIdElectronicDevice(deviceDetail.getIdElectronicDevice());
        Component component = componentService.findByIdComponent(deviceDetail.getIdComponent());
        DeviceDetail deviceDetail1= findByIdDeviceDetail(deviceDetail.getIdDeviceDetail());
        deviceDetail1.setQuantityDeviceDetail(deviceDetail.getQuantityDeviceDetail());
        deviceDetail1.setPriceDeviceDetail(deviceDetail.getPriceDeviceDetail());
        deviceDetail1.setComponent(component);
        deviceDetail1.setElectronicDevice(electronicDevice);
        return deviceDetailRepository.save(deviceDetail1);
    }
    public void deleteDeviceDetail(long id){
        deviceDetailRepository.deleteById(id);
    }
}
