package com.uptc.frw.casoestudioredis.services;

import com.uptc.frw.casoestudioredis.jpa.model.Client;
import com.uptc.frw.casoestudioredis.jpa.model.DeviceDetail;
import com.uptc.frw.casoestudioredis.jpa.repository.ClientRepository;
import com.uptc.frw.casoestudioredis.jpa.repository.DeviceDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceDetailService {
    @Autowired
    private DeviceDetailRepository deviceDetailRepository;

    public List<DeviceDetail> findAllDeviceDetails() {
        return deviceDetailRepository.findAll();
    }
    public DeviceDetail findByIdDeviceDetail(Long id){
        return deviceDetailRepository.findById(id).orElse(null);
    }
    public DeviceDetail saveDeviceDetail(DeviceDetail deviceDetail){
        return deviceDetailRepository.save(deviceDetail);
    }
    public DeviceDetail updateDevClient(DeviceDetail deviceDetail){
        DeviceDetail deviceDetail1= findByIdDeviceDetail(deviceDetail.getIdDeviceDetail());
        deviceDetail1.setQuantityDeviceDetail(deviceDetail.getQuantityDeviceDetail());
        deviceDetail1.setPriceDeviceDetail(deviceDetail.getPriceDeviceDetail());
        deviceDetail1.setIdComponent(deviceDetail.getIdComponent());
        deviceDetail1.setElectronicDevice(deviceDetail.getElectronicDevice());
        return deviceDetailRepository.save(deviceDetail1);
    }
    public void deleteDeviceDetail(long id){
        deviceDetailRepository.deleteById(id);
    }
}
