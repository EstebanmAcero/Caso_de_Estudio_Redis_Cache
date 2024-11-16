package com.uptc.frw.casoestudioredis.jpa.model.key;

import com.uptc.frw.casoestudioredis.jpa.model.Component;
import com.uptc.frw.casoestudioredis.jpa.model.Repair;

import java.io.Serializable;

/**
 * Esta clase representa una clave compuesta para la entidad que relaciona los componentes y reparaciones.
 * Implementa la interfaz Serializable, lo que permite que la clave compuesta sea serializada,
 * facilitando su almacenamiento y transporte entre sistemas.
 *
 * La clave compuesta se compone de dos atributos:
 *  - Un componente (de tipo {@link Component})
 *  - Una reparación (de tipo {@link Repair})
 *
 * Estos dos atributos son utilizados para identificar de manera única una relación entre un componente
 * y una reparación en la base de datos o el modelo de datos.
 *
 * Las clases {@link Component} y {@link Repair} deben ser correctamente implementadas para que
 * esta clase funcione como una clave compuesta válida.
 */
public class ComponentRepairKey implements Serializable {
    /**
     * Atributo que representa el componente asociado a la clave compuesta.
     * @see Component
     */
    private Component componentRepairKey;

    /**
     * Atributo que representa la reparación asociada a la clave compuesta.
     * @see Repair
     */
    private Repair repairComponentKey;

    /**
     * Obtiene el componente asociado a esta clave compuesta.
     *
     * @return El componente asociado a la clave.
     */
    public Component getComponentRepairKey() {
        return componentRepairKey;
    }

    /**
     * Establece el componente asociado a esta clave compuesta.
     *
     * @param componentRepairKey El componente a asignar.
     */
    public void setComponentRepairKey(Component componentRepairKey) {
        this.componentRepairKey = componentRepairKey;
    }

    /**
     * Obtiene la reparación asociada a esta clave compuesta.
     *
     * @return La reparación asociada a la clave.
     */
    public Repair getRepairComponentKey() {
        return repairComponentKey;
    }

    /**
     * Establece la reparación asociada a esta clave compuesta.
     *
     * @param repairComponentKey La reparación a asignar.
     */
    public void setRepairComponentKey(Repair repairComponentKey) {
        this.repairComponentKey = repairComponentKey;
    }
}
