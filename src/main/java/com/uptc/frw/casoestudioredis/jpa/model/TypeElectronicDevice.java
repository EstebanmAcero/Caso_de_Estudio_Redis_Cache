package com.uptc.frw.casoestudioredis.jpa.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "TIPOELECTRODOMESTICO")
public class TypeElectronicDevice {
    @Id
    @Column(name = "ID_TIPO")
    private long idTypeElectronicDevice;
    @Column(name = "NOMBRE")
    private String nameElectronicDevice;
    @Column(name = "CARACTERISTICAS")
    private String characteristicsElectronicDevice;
    @Column(name = "TIPO_PADRE", insertable = false, updatable = false)
    private long typeElectronicDevice;
    @OneToMany(mappedBy = "typeElectronicDevice")
    private List<ElectronicDevice> electronicDevicesList;
    @ManyToOne
    @JoinColumn(name= "TIPO_PADRE")
    private TypeElectronicDevice parentTypeElectronicDevice;
    @OneToMany(mappedBy = "parentTypeElectronicDevice")
    private List<TypeElectronicDevice> typeElectronicDevicesList;
    public TypeElectronicDevice() {}

    public long getIdTypeElectronicDevice() {
        return idTypeElectronicDevice;
    }

    public void setIdTypeElectronicDevice(long idTypeElectronicDevice) {
        this.idTypeElectronicDevice = idTypeElectronicDevice;
    }

    public String getNameElectronicDevice() {
        return nameElectronicDevice;
    }

    public void setNameElectronicDevice(String nameElectronicDevice) {
        this.nameElectronicDevice = nameElectronicDevice;
    }

    public String getCharacteristicsElectronicDevice() {
        return characteristicsElectronicDevice;
    }

    public void setCharacteristicsElectronicDevice(String characteristicsElectronicDevice) {
        this.characteristicsElectronicDevice = characteristicsElectronicDevice;
    }

    public long getTypeElectronicDevice() {
        return typeElectronicDevice;
    }

    public void setTypeElectronicDevice(long typeElectronicDevice) {
        this.typeElectronicDevice = typeElectronicDevice;
    }

    public List<ElectronicDevice> getElectronicDevicesList() {
        return electronicDevicesList;
    }

    public void setElectronicDevicesList(List<ElectronicDevice> electronicDevicesList) {
        this.electronicDevicesList = electronicDevicesList;
    }

    public TypeElectronicDevice getParentTypeElectronicDevice() {
        return parentTypeElectronicDevice;
    }

    public void setParentTypeElectronicDevice(TypeElectronicDevice parentTypeElectronicDevice) {
        this.parentTypeElectronicDevice = parentTypeElectronicDevice;
    }

    public List<TypeElectronicDevice> getTypeElectronicDevicesList() {
        return typeElectronicDevicesList;
    }

    public void setTypeElectronicDevicesList(List<TypeElectronicDevice> typeElectronicDevicesList) {
        this.typeElectronicDevicesList = typeElectronicDevicesList;
    }

    @Override
    public String toString() {
        return "TypeElectronicDevice{" +
                "idTypeElectronicDevice=" + idTypeElectronicDevice +
                ", nameElectronicDevice='" + nameElectronicDevice + '\'' +
                ", characteristicsElectronicDevice='" + characteristicsElectronicDevice + '\'' +
                ", typeElectronicDevice=" + typeElectronicDevice +
                '}';
    }
}
