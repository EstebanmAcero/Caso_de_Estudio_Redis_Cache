package com.uptc.frw.casoestudioredis.controller;

import com.uptc.frw.casoestudioredis.jpa.model.Client;
import com.uptc.frw.casoestudioredis.jpa.model.DeviceDetail;
import com.uptc.frw.casoestudioredis.services.ClientService;
import com.uptc.frw.casoestudioredis.services.DeviceDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("devDetail")
public class DeviceDetailController {
    @Autowired
    public DeviceDetailService deviceDetailService;

    @GetMapping
    @Cacheable(
            value = "DeviceDetail",
            key = "'allDeviceDetail'",
            unless = "#result == null"
    )

    public List<DeviceDetail> getAllDeviceDetails(){
        return deviceDetailService.findAllDeviceDetails();
    }

    @GetMapping("{id}")
    @Cacheable(
            value = "DeviceDetail",
            key = "#id",
            unless = "#result == null"
    )

    public DeviceDetail getDeviceDetail(@PathVariable long id){
        return deviceDetailService.findByIdDeviceDetail(id);
    }
    @PostMapping
    public DeviceDetail addDeviceDetail(@RequestBody DeviceDetail deviceDetail){
        return deviceDetailService.saveDeviceDetail(deviceDetail);
    }

    @PutMapping
    @CachePut(
            value = "DeviceDetail",
            key = "#devicedetail.iddevicedetail",
            unless = "#result == null"
    )

    public DeviceDetail updateDeviceDetail(@RequestBody DeviceDetail deviceDetail){
        return deviceDetailService.updateDevClient(deviceDetail);
    }

    @DeleteMapping
    @CacheEvict(
            value = "DeviceDetail",
            key = "#id"
    )

    public void deleteDeviceService(@RequestParam long id){
        deviceDetailService.deleteDeviceDetail(id);
    }
}
