package com.uptc.frw.casoestudioredis.jpa.model;

import com.uptc.frw.casoestudioredis.jpa.model.key.ComponentRepairKey;
import jakarta.persistence.*;

/**
 * Representa la relación entre un componente y una reparación. La clase está mapeada
 * a la tabla "REPARACIONCOMPONENTE" en la base de datos y utiliza una clave compuesta
 * (representada por la clase `ComponentRepairKey`) para relacionar los componentes con las reparaciones.
 */
@Entity
@Table(name = "REPARACIONCOMPONENTE")
@IdClass(ComponentRepairKey.class)  // Define la clave compuesta utilizando ComponentRepairKey
public class ComponentRepair {

    /**
     * Relación muchos a uno con la entidad Component.
     * Se usa la anotación @Id para indicar que esta columna forma parte de la clave primaria compuesta.
     */
    @Id
    @ManyToOne
    @JoinColumn(name = "ID_COMPONENTE") // Relación con el componente mediante la columna "ID_COMPONENTE"
    private Component componentRepairKey;

    /**
     * Relación muchos a uno con la entidad Repair.
     * Se usa la anotación @Id para indicar que esta columna forma parte de la clave primaria compuesta.
     */
    @Id
    @ManyToOne
    @JoinColumn(name = "ID_REPARACION") // Relación con la reparación mediante la columna "ID_REPARACION"
    private Repair repairComponentKey;

    /**
     * El identificador de la reparación. Este campo no se inserta ni actualiza directamente en la base de datos.
     */
    @Column(name = "ID_REPARACION", insertable = false, updatable = false)
    private long idRepair;

    /**
     * El identificador del componente. Este campo no se inserta ni actualiza directamente en la base de datos.
     */
    @Column(name = "ID_COMPONENTE", insertable = false, updatable = false)
    private long idComponent;

    /**
     * La cantidad de componentes involucrados en una reparación. Este valor representa la cantidad
     * del componente específico que se utiliza en una reparación.
     */
    @Column(name = "CANTIDAD")
    private long quantityComponentRepair;

    /**
     * Constructor vacío requerido por JPA para la creación de instancias de la entidad.
     */
    public ComponentRepair() {
    }

    // Getters y setters

    /**
     * Obtiene el identificador de la reparación.
     * @return El identificador de la reparación.
     */
    public long getIdRepair() {
        return idRepair;
    }

    /**
     * Establece el identificador de la reparación.
     * @param idRepair El identificador de la reparación.
     */
    public void setIdRepair(long idRepair) {
        this.idRepair = idRepair;
    }

    /**
     * Obtiene el identificador del componente.
     * @return El identificador del componente.
     */
    public long getIdComponent() {
        return idComponent;
    }

    /**
     * Establece el identificador del componente.
     * @param idComponent El identificador del componente.
     */
    public void setIdComponent(long idComponent) {
        this.idComponent = idComponent;
    }

    /**
     * Obtiene la cantidad de componentes utilizados en la reparación.
     * @return La cantidad de componentes.
     */
    public long getQuantityComponentRepair() {
        return quantityComponentRepair;
    }

    /**
     * Establece la cantidad de componentes utilizados en la reparación.
     * @param quantityComponentRepair La cantidad de componentes.
     */
    public void setQuantityComponentRepair(long quantityComponentRepair) {
        this.quantityComponentRepair = quantityComponentRepair;
    }

    /**
     * Obtiene el componente asociado a esta relación de reparación.
     * @return El componente asociado.
     */
    public Component getComponentRepairKey() {
        return componentRepairKey;
    }

    /**
     * Establece el componente asociado a esta relación de reparación.
     * @param componentRepairKey El componente asociado.
     */
    public void setComponentRepairKey(Component componentRepairKey) {
        this.componentRepairKey = componentRepairKey;
    }

    /**
     * Obtiene la reparación asociada a este componente.
     * @return La reparación asociada.
     */
    public Repair getRepairComponentKey() {
        return repairComponentKey;
    }

    /**
     * Establece la reparación asociada a este componente.
     * @param repairComponentKey La reparación asociada.
     */
    public void setRepairComponentKey(Repair repairComponentKey) {
        this.repairComponentKey = repairComponentKey;
    }

    /**
     * Método `toString` que devuelve una representación textual de la entidad `ComponentRepair`.
     * @return Una cadena con la representación de la relación componente-reparación.
     */
    @Override
    public String toString() {
        return "ComponentRepair{" +
                "idRepair=" + idRepair +
                ", idComponent=" + idComponent +
                ", quantityComponentRepair=" + quantityComponentRepair +
                '}';
    }
}
