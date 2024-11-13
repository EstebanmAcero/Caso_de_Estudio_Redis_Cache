package com.uptc.frw.casoestudioredis.jpa.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Entity
@Table(name= "APARATOELECTRONICO")
public class ElectronicDevice {
    @Id
    @Column(name = "ID_APARATO")
    private long idElectronicDevice;
    @Column(name = "DESCRIPCION")
    private String descriptionElectronicDevice;
    @Column(name = "ID_TIPO", insertable = false, updatable = false)
    private long idTypeElectronicDevice;
    @OneToMany(mappedBy = "electronicDevice")
    private List<DeviceDetail> deviceDetails;
    @OneToMany(mappedBy = "electronicDeviceRepair")
    private List<Repair> repairElectronicDevices;
    @ManyToOne
    @JoinColumn(name = "ID_TIPO")
    @JsonIgnore
    private TypeElectronicDevice typeElectronicDevice;
    public ElectronicDevice() {
    }

    public long getIdElectronicDevice() {
        return idElectronicDevice;
    }

    public void setIdElectronicDevice(long idElectronicDevice) {
        this.idElectronicDevice = idElectronicDevice;
    }

    public String getDescriptionElectronicDevice() {
        return descriptionElectronicDevice;
    }

    public void setDescriptionElectronicDevice(String descriptionElectronicDevice) {
        this.descriptionElectronicDevice = descriptionElectronicDevice;
    }

    public long getIdTypeElectronicDevice() {
        return idTypeElectronicDevice;
    }

    public void setIdTypeElectronicDevice(long idTypeElectronicDevice) {
        this.idTypeElectronicDevice = idTypeElectronicDevice;
    }

    public List<DeviceDetail> getDeviceDetails() {
        return deviceDetails;
    }

    public void setDeviceDetails(List<DeviceDetail> deviceDetails) {
        this.deviceDetails = deviceDetails;
    }

    public List<Repair> getRepairElectronicDevices() {
        return repairElectronicDevices;
    }

    public void setRepairElectronicDevices(List<Repair> repairElectronicDevices) {
        this.repairElectronicDevices = repairElectronicDevices;
    }

    public TypeElectronicDevice getTypeElectronicDevice() {
        return typeElectronicDevice;
    }

    public void setTypeElectronicDevice(TypeElectronicDevice typeElectronicDevice) {
        this.typeElectronicDevice = typeElectronicDevice;
    }

    @Override
    public String toString() {
        return "ElectronicDevice{" +
                "idElectronicDevice=" + idElectronicDevice +
                ", descriptionElectronicDevice='" + descriptionElectronicDevice + '\'' +
                ", idTypeElectronicDevice=" + idTypeElectronicDevice +
                '}';
    }
}
