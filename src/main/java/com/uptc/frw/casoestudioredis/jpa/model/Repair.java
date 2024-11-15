package com.uptc.frw.casoestudioredis.jpa.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "REPARACION")
public class Repair {
    @Id
    @Column(name = "ID_REPARACION")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reparacionGen")
    @SequenceGenerator(name = "reparacionGen",sequenceName = "REPARACION_SEQ", allocationSize = 1)
    private long idRepair;
    @Column(name = "FECHA_ENTRADA")
    private Date dateInRepair;
    @Column(name = "FECHA_SALIDA")
    private Date dateOutRepair;
    @Column(name = "DESCRIPCION_PROBLEMA")
    private String descriptionProblem;
    @Column(name = "ID_APARATO", insertable = false, updatable = false)
    private long idElectronicDevice;
    @Column(name = "ID_CLIENTE", insertable = false, updatable = false)
    private long idClient;
    @ManyToOne
    @JoinColumn(name= "ID_APARATO")
    private ElectronicDevice electronicDeviceRepair;
    @ManyToOne
    @JoinColumn(name="ID_CLIENTE")
    @JsonIgnore
    private Client clientRepair;
    @OneToMany(mappedBy = "repairComponentKey")
    private List<ComponentRepair> componentsRepair;
    public Repair() {
    }

    public long getIdRepair() {
        return idRepair;
    }

    public void setIdRepair(long idRepair) {
        this.idRepair = idRepair;
    }

    public Date getDateInRepair() {
        return dateInRepair;
    }

    public void setDateInRepair(Date dateInRepair) {
        this.dateInRepair = dateInRepair;
    }

    public Date getDateOutRepair() {
        return dateOutRepair;
    }

    public void setDateOutRepair(Date dateOutRepair) {
        this.dateOutRepair = dateOutRepair;
    }

    public String getDescriptionProblem() {
        return descriptionProblem;
    }

    public void setDescriptionProblem(String descriptionProblem) {
        this.descriptionProblem = descriptionProblem;
    }

    public long getIdElectronicDevice() {
        return idElectronicDevice;
    }

    public void setIdElectronicDevice(long idElectronicDevice) {
        this.idElectronicDevice = idElectronicDevice;
    }

    public long getIdClient() {
        return idClient;
    }

    public void setIdClient(long idClient) {
        this.idClient = idClient;
    }

    public ElectronicDevice getElectronicDeviceRepair() {
        return electronicDeviceRepair;
    }

    public void setElectronicDeviceRepair(ElectronicDevice electronicDeviceRepair) {
        this.electronicDeviceRepair = electronicDeviceRepair;
    }

    public Client getClientRepair() {
        return clientRepair;
    }

    public void setClientRepair(Client clientRepair) {
        this.clientRepair = clientRepair;
    }

    public List<ComponentRepair> getComponentsRepair() {
        return componentsRepair;
    }

    public void setComponentsRepair(List<ComponentRepair> componentsRepair) {
        this.componentsRepair = componentsRepair;
    }

    @Override
    public String toString() {
        return "Repair{" +
                "idRepair=" + idRepair +
                ", dateInRepair=" + dateInRepair +
                ", dateOutRepair=" + dateOutRepair +
                ", descriptionProblem='" + descriptionProblem + '\'' +
                ", idElectronicDevice=" + idElectronicDevice +
                ", idClient=" + idClient +
                '}';
    }
}
