package com.uptc.frw.casoestudioredis.jpa.model;

import com.uptc.frw.casoestudioredis.jpa.model.key.ComponentRepairKey;
import jakarta.persistence.*;

@Entity
@Table(name = "REPARACIONCOMPONENTE")
@IdClass(ComponentRepairKey.class)
public class ComponentRepair {
    @Id
    @ManyToOne
    @JoinColumn(name = "ID_COMPONENTE")
    private Component componentRepairKey;
    @Id
    @ManyToOne
    @JoinColumn(name = "ID_REPARACION")
    private Repair repairComponentKey;

    @Column(name = "ID_REPARACION", insertable = false, updatable = false)
    private long idRepair;
    @Column(name = "ID_COMPONENTE",insertable = false, updatable = false)
    private long idComponent;
    @Column(name = "CANTIDAD")
    private long quantityComponentRepair;

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

    public Component getComponentRepairKey() {
        return componentRepairKey;
    }

    public void setComponentRepairKey(Component componentRepairKey) {
        this.componentRepairKey = componentRepairKey;
    }

    public Repair getRepairComponentKey() {
        return repairComponentKey;
    }

    public void setRepairComponentKey(Repair repairComponentKey) {
        this.repairComponentKey = repairComponentKey;
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
