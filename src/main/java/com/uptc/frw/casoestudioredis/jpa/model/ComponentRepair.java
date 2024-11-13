package com.uptc.frw.casoestudioredis.jpa.model;

import jakarta.persistence.*;

@Entity
@Table(name = "REPARACIONCOMPONENTE")
public class ComponentRepair {
    @Id
    @Column(name = "ID_REPARACION", insertable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "reparacionComGen")
    @SequenceGenerator(name = "reparacionComGen",sequenceName = "REPARACIONCOMP_SEQ", allocationSize = 1)
    private long idRepair;
    @Column(name = "ID_COMPONENTE",insertable = false, updatable = false)
    private long idComponent;
    @Column(name = "CANTIDAD")
    private long quantityComponentRepair;
    @ManyToOne
    @JoinColumn(name= "ID_REPARACION")
    private Repair repairComponet;
    @ManyToOne
    @JoinColumn(name = "ID_COMPONENTE")
    private Component component;
    public ComponentRepair() {
    }

    public long getIdRepair() {
        return idRepair;
    }

    public void setIdRepair(long idRepair) {
        this.idRepair = idRepair;
    }

    public long getIdComponent() {
        return idComponent;
    }

    public void setIdComponent(long idComponent) {
        this.idComponent = idComponent;
    }

    public long getQuantityComponentRepair() {
        return quantityComponentRepair;
    }

    public void setQuantityComponentRepair(long quantityComponentRepair) {
        this.quantityComponentRepair = quantityComponentRepair;
    }

    public Repair getRepairComponet() {
        return repairComponet;
    }

    public void setRepairComponet(Repair repairComponet) {
        this.repairComponet = repairComponet;
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    @Override
    public String toString() {
        return "ComponentRepair{" +
                "idRepair=" + idRepair +
                ", idComponent=" + idComponent +
                ", quantityComponentRepair=" + quantityComponentRepair +
                '}';
    }
}
