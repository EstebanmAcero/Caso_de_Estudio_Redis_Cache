package com.uptc.frw.casoestudioredis.jpa.model.key;

import com.uptc.frw.casoestudioredis.jpa.model.Component;
import com.uptc.frw.casoestudioredis.jpa.model.Repair;

import java.io.Serializable;

public class ComponentRepairKey implements Serializable {
    private Component componentRepairKey;
    private Repair repairComponentKey;

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
}
