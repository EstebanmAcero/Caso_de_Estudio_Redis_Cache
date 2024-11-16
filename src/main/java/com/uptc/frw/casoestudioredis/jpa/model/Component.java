package com.uptc.frw.casoestudioredis.jpa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

/**
 * Representa un componente en el sistema. Esta clase está mapeada a la tabla COMPONENTE
 * en la base de datos. La clase es serializable, lo que permite su almacenamiento y transporte.
 * Además, mantiene relaciones con otras entidades como Manufacturer, DeviceDetail y ComponentRepair.
 */
@Entity
@Table(name = "COMPONENTE")
public class Component implements Serializable {

    /**
     * El identificador único del componente. Este campo está mapeado a la columna "ID_COMPONENTE".
     * Se genera automáticamente utilizando una secuencia.
     */
    @Id
    @Column(name = "ID_COMPONENTE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "componentGen")
    @SequenceGenerator(name = "componentGen", sequenceName = "COMPONENTE_SEQ", allocationSize = 1)
    private long idComponent;

    /**
     * El nombre del componente. Está mapeado a la columna "NOMBRE".
     */
    @Column(name = "NOMBRE")
    private String nameComponent;

    /**
     * La descripción del componente. Está mapeada a la columna "ESPECIFICACIONES".
     */
    @Column(name = "ESPECIFICACIONES")
    private String descriptionComponent;

    /**
     * El identificador del fabricante del componente. Está mapeado a la columna "ID_FABRICANTE".
     * Este campo es solo para referencia y no puede ser insertado ni actualizado directamente en la base de datos.
     */
    @Column(name = "ID_FABRICANTE", insertable = false, updatable = false)
    private long idManufacturer;

    /**
     * La relación de muchos a uno entre Component y Manufacturer. Cada componente tiene un fabricante.
     * La columna "ID_FABRICANTE" es utilizada para establecer esta relación.
     */
    @ManyToOne
    @JsonIgnore // Ignora este campo al serializar a JSON para evitar bucles infinitos.
    @JoinColumn(name = "ID_FABRICANTE")
    private Manufacturer manufacturer;

    /**
     * Relación de uno a muchos entre Component y DeviceDetail.
     * Un componente puede estar asociado a múltiples detalles de dispositivos.
     */
    @OneToMany(mappedBy = "component", fetch = FetchType.EAGER)
    @JsonIgnore // Ignora este campo al serializar a JSON para evitar bucles infinitos.
    private List<DeviceDetail> deviceDetailsComponet;

    /**
     * Relación de uno a muchos entre Component y ComponentRepair.
     * Un componente puede estar asociado a múltiples reparaciones.
     */
    @OneToMany(mappedBy = "componentRepairKey", fetch = FetchType.EAGER)
    @JsonIgnore // Ignora este campo al serializar a JSON para evitar bucles infinitos.
    private List<ComponentRepair> componentRepairList;

    /**
     * Constructor vacío para la creación de instancias por JPA.
     */
    public Component() {
    }

    /**
     * Obtiene el identificador único del componente.
     * @return El identificador único del componente.
     */
    public long getIdComponent() {
        return idComponent;
    }

    /**
     * Establece el identificador único del componente.
     * @param idComponent El identificador único del componente.
     */
    public void setIdComponent(long idComponent) {
        this.idComponent = idComponent;
    }

    /**
     * Obtiene el nombre del componente.
     * @return El nombre del componente.
     */
    public String getNameComponent() {
        return nameComponent;
    }

    /**
     * Establece el nombre del componente.
     * @param nameComponent El nombre del componente.
     */
    public void setNameComponent(String nameComponent) {
        this.nameComponent = nameComponent;
    }

    /**
     * Obtiene la descripción del componente.
     * @return La descripción del componente.
     */
    public String getDescriptionComponent() {
        return descriptionComponent;
    }

    /**
     * Establece la descripción del componente.
     * @param descriptionComponent La descripción del componente.
     */
    public void setDescriptionComponent(String descriptionComponent) {
        this.descriptionComponent = descriptionComponent;
    }

    /**
     * Obtiene el identificador del fabricante del componente.
     * @return El identificador del fabricante.
     */
    public long getIdManufacturer() {
        return idManufacturer;
    }

    /**
     * Establece el identificador del fabricante del componente.
     * @param idManufacturer El identificador del fabricante.
     */
    public void setIdManufacturer(long idManufacturer) {
        this.idManufacturer = idManufacturer;
    }

    /**
     * Obtiene el fabricante asociado al componente.
     * @return El fabricante asociado.
     */
    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    /**
     * Establece el fabricante asociado al componente.
     * @param manufacturer El fabricante asociado.
     */
    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * Obtiene la lista de detalles de dispositivos asociados al componente.
     * @return La lista de detalles de dispositivos.
     */
    public List<DeviceDetail> getDeviceDetailsComponet() {
        return deviceDetailsComponet;
    }

    /**
     * Establece la lista de detalles de dispositivos asociados al componente.
     * @param deviceDetailsComponet La lista de detalles de dispositivos.
     */
    public void setDeviceDetailsComponet(List<DeviceDetail> deviceDetailsComponet) {
        this.deviceDetailsComponet = deviceDetailsComponet;
    }

    /**
     * Obtiene la lista de reparaciones asociadas al componente.
     * @return La lista de reparaciones.
     */
    public List<ComponentRepair> getComponentRepairList() {
        return componentRepairList;
    }

    /**
     * Establece la lista de reparaciones asociadas al componente.
     * @param componentRepairList La lista de reparaciones.
     */
    public void setComponentRepairList(List<ComponentRepair> componentRepairList) {
        this.componentRepairList = componentRepairList;
    }

    /**
     * Método toString que proporciona una representación textual del objeto Component.
     * @return Una cadena de texto representando el componente.
     */
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
