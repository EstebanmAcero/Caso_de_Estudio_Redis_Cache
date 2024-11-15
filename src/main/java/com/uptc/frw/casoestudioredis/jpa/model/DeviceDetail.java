package com.uptc.frw.casoestudioredis.jpa.model;

import jakarta.persistence.*;

@Entity
@Table(name= "APARATODETALLE")
public class DeviceDetail {
    @Id
    @Column(name= "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "aparatoDetGen")
    @SequenceGenerator(name = "aparatoDetGen",sequenceName = "APARATODET_SEQ",allocationSize=1)
    private long idDeviceDetail;
    @Column(name= "ID_APARATO", insertable = false, updatable = false)
    private long idElectronicDevice;
    @Column(name= "ID_COMPONENTE", insertable = false, updatable = false)
    private long idComponent;
    @Column(name= "CANTIDAD")
    private long quantityDeviceDetail;
    @Column(name= "PRECIO")
    private long priceDeviceDetail;
    @ManyToOne
    @JoinColumn(name= "ID_COMPONENTE")
    private Component component;
    @ManyToOne
    @JoinColumn(name= "ID_APARATO")
    private ElectronicDevice electronicDevice;
    public DeviceDetail() {
    }

    public long getIdDeviceDetail() {
        return idDeviceDetail;
    }

    public void setIdDeviceDetail(long idDeviceDetail) {
        this.idDeviceDetail = idDeviceDetail;
    }

    public long getIdElectronicDevice() {
        return idElectronicDevice;
    }

    public void setIdElectronicDevice(long idElectronicDevice) {
        this.idElectronicDevice = idElectronicDevice;
    }

    public long getIdComponent() {
        return idComponent;
    }

    public void setIdComponent(long idComponent) {
        this.idComponent = idComponent;
    }

    public long getQuantityDeviceDetail() {
        return quantityDeviceDetail;
    }

    public void setQuantityDeviceDetail(long quantityDeviceDetail) {
        this.quantityDeviceDetail = quantityDeviceDetail;
    }

    public long getPriceDeviceDetail() {
        return priceDeviceDetail;
    }

    public void setPriceDeviceDetail(long priceDeviceDetail) {
        this.priceDeviceDetail = priceDeviceDetail;
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    public ElectronicDevice getElectronicDevice() {
        return electronicDevice;
    }

    public void setElectronicDevice(ElectronicDevice electronicDevice) {
        this.electronicDevice = electronicDevice;
    }

    @Override
    public String toString() {
        return "DeviceDetail{" +
                "idDeviceDetail=" + idDeviceDetail +
                ", idElectronicDevice=" + idElectronicDevice +
                ", idComponent=" + idComponent +
                ", quantityDeviceDetail=" + quantityDeviceDetail +
                ", priceDeviceDetail=" + priceDeviceDetail +
                '}';
    }
}
