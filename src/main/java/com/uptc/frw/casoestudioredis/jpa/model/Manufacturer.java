package com.uptc.frw.casoestudioredis.jpa.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="FABRICANTE")
public class Manufacturer {
    @Id
    @Column(name="ID_FABRICANTE")
    private long idManufacturer;
    @Column(name="NOMBRE")
    private String nameManufacturer;
    @Column(name="DIRECCION")
    private String addressManufacturer;
    @Column(name="TELEFONO")
    private String phoneManufacturer;
    @Column(name="RIF")
    private String rifManufacturer;
    @Column(name="DOMICILIOFISCAL")
    private String fiscalDomicileManufacturer;
    @OneToMany(mappedBy = "manufacturer")
    private List<Component> components;
    public Manufacturer() {
    }

    public long getIdManufacturer() {
        return idManufacturer;
    }

    public void setIdManufacturer(long idManufacturer) {
        this.idManufacturer = idManufacturer;
    }

    public String getNameManufacturer() {
        return nameManufacturer;
    }

    public void setNameManufacturer(String nameManufacturer) {
        this.nameManufacturer = nameManufacturer;
    }

    public String getAddressManufacturer() {
        return addressManufacturer;
    }

    public void setAddressManufacturer(String addressManufacturer) {
        this.addressManufacturer = addressManufacturer;
    }

    public String getPhoneManufacturer() {
        return phoneManufacturer;
    }

    public void setPhoneManufacturer(String phoneManufacturer) {
        this.phoneManufacturer = phoneManufacturer;
    }

    public String getRifManufacturer() {
        return rifManufacturer;
    }

    public void setRifManufacturer(String rifManufacturer) {
        this.rifManufacturer = rifManufacturer;
    }

    public String getFiscalDomicileManufacturer() {
        return fiscalDomicileManufacturer;
    }

    public void setFiscalDomicileManufacturer(String fiscalDomicileManufacturer) {
        this.fiscalDomicileManufacturer = fiscalDomicileManufacturer;
    }

    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "idManufacturer=" + idManufacturer +
                ", nameManufacturer='" + nameManufacturer + '\'' +
                ", addressManufacturer='" + addressManufacturer + '\'' +
                ", phoneManufacturer='" + phoneManufacturer + '\'' +
                ", rifManufacturer='" + rifManufacturer + '\'' +
                ", fiscalDomicileManufacturer='" + fiscalDomicileManufacturer + '\'' +
                '}';
    }
}

