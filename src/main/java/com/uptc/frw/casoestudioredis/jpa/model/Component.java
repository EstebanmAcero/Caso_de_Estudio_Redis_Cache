package com.uptc.frw.casoestudioredis.jpa.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name= "COMPONENTE")
public class Component {
    @Id
    @Column(name = "ID_COMPONENTE")
    private long idComponent;
    @Column(name = "NOMBRE")
    private String nameComponent;
    @Column(name = "ESPECIFICACIONES")
    private String descriptionComponent;
    @Column(name = "ID_FABRICANTE", insertable = false, updatable = false)
    private long idManufacturer;
    @ManyToOne
    @JoinColumn(name = "ID_FABRICANTE")
    private Manufacturer manufacturer;
    @OneToMany(mappedBy = "component")
    private List<DeviceDetail> deviceDetailsComponet;
    @OneToMany(mappedBy = "component")
    private List<ComponentRepair> componentRepairList;
    public Component() {
    }

    public long getIdComponent() {
        return idComponent;
    }

    public void setIdComponent(long idComponent) {
        this.idComponent = idComponent;
    }

    public String getNameComponent() {
        return nameComponent;
    }

    public void setNameComponent(String nameComponent) {
        this.nameComponent = nameComponent;
    }

    public String getDescriptionComponent() {
        return descriptionComponent;
    }

    public void setDescriptionComponent(String descriptionComponent) {
        this.descriptionComponent = descriptionComponent;
    }

    public long getIdManufacturer() {
        return idManufacturer;
    }

    public void setIdManufacturer(long idManufacturer) {
        this.idManufacturer = idManufacturer;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public List<DeviceDetail> getDeviceDetailsComponet() {
        return deviceDetailsComponet;
    }

    public void setDeviceDetailsComponet(List<DeviceDetail> deviceDetailsComponet) {
        this.deviceDetailsComponet = deviceDetailsComponet;
    }

    public List<ComponentRepair> getComponentRepairList() {
        return componentRepairList;
    }

    public void setComponentRepairList(List<ComponentRepair> componentRepairList) {
        this.componentRepairList = componentRepairList;
    }

    @Override
    public String toString() {
        return "Component{" +
                "idComponent=" + idComponent +
                ", nameComponent='" + nameComponent + '\'' +
                ", descriptionComponent='" + descriptionComponent + '\'' +
                ", idManufacturer=" + idManufacturer +
                '}';
    }
}
