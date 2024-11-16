package com.uptc.frw.casoestudioredis.jpa.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

/**
 * Representa un dispositivo electrónico, incluyendo su descripción, tipo y las relaciones con otros
 * objetos, como los detalles del dispositivo y las reparaciones asociadas. La clase mapea la tabla
 * "APARATOELECTRONICO" en la base de datos.
 */
@Entity
@Table(name = "APARATOELECTRONICO")
public class ElectronicDevice {

    /**
     * Identificador único del dispositivo electrónico. Es la clave primaria de la tabla.
     */
    @Id
    @Column(name = "ID_APARATO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aparatoGen")
    @SequenceGenerator(name = "aparatoGen", sequenceName = "APARATO_SEQ", allocationSize = 1)
    private long idElectronicDevice;

    /**
     * Descripción del dispositivo electrónico. Representa una breve explicación o nombre del dispositivo.
     */
    @Column(name = "DESCRIPCION")
    private String descriptionElectronicDevice;

    /**
     * Identificador del tipo de dispositivo electrónico. Este campo está marcado como no insertable ni
     * actualizable, ya que se utiliza para establecer la relación con la entidad `TypeElectronicDevice`.
     */
    @Column(name = "ID_TIPO", insertable = false, updatable = false)
    private long idTypeElectronicDevice;

    /**
     * Relación uno a muchos con la entidad `DeviceDetail`. Un dispositivo electrónico puede tener múltiples
     * detalles de dispositivos asociados.
     */
    @OneToMany(mappedBy = "electronicDevice")
    private List<DeviceDetail> deviceDetails;

    /**
     * Relación uno a muchos con la entidad `Repair`. Un dispositivo electrónico puede tener múltiples reparaciones asociadas.
     */
    @OneToMany(mappedBy = "electronicDeviceRepair")
    private List<Repair> repairElectronicDevices;

    /**
     * Relación muchos a uno con la entidad `TypeElectronicDevice`. Un dispositivo electrónico tiene un tipo específico.
     */
    @ManyToOne
    @JoinColumn(name = "ID_TIPO")
    @JsonIgnore
    private TypeElectronicDevice typeElectronicDevice;

    /**
     * Constructor vacío requerido por JPA para la creación de instancias de la entidad.
     */
    public ElectronicDevice() {
    }

    // Getters y setters

    /**
     * Obtiene el identificador del dispositivo electrónico.
     * @return El identificador del dispositivo electrónico.
     */
    public long getIdElectronicDevice() {
        return idElectronicDevice;
    }

    /**
     * Establece el identificador del dispositivo electrónico.
     * @param idElectronicDevice El identificador del dispositivo electrónico.
     */
    public void setIdElectronicDevice(long idElectronicDevice) {
        this.idElectronicDevice = idElectronicDevice;
    }

    /**
     * Obtiene la descripción del dispositivo electrónico.
     * @return La descripción del dispositivo electrónico.
     */
    public String getDescriptionElectronicDevice() {
        return descriptionElectronicDevice;
    }

    /**
     * Establece la descripción del dispositivo electrónico.
     * @param descriptionElectronicDevice La descripción del dispositivo electrónico.
     */
    public void setDescriptionElectronicDevice(String descriptionElectronicDevice) {
        this.descriptionElectronicDevice = descriptionElectronicDevice;
    }

    /**
     * Obtiene el identificador del tipo de dispositivo electrónico.
     * @return El identificador del tipo de dispositivo electrónico.
     */
    public long getIdTypeElectronicDevice() {
        return idTypeElectronicDevice;
    }

    /**
     * Establece el identificador del tipo de dispositivo electrónico.
     * @param idTypeElectronicDevice El identificador del tipo de dispositivo electrónico.
     */
    public void setIdTypeElectronicDevice(long idTypeElectronicDevice) {
        this.idTypeElectronicDevice = idTypeElectronicDevice;
    }

    /**
     * Obtiene la lista de detalles del dispositivo electrónico.
     * @return La lista de detalles del dispositivo electrónico.
     */
    public List<DeviceDetail> getDeviceDetails() {
        return deviceDetails;
    }

    /**
     * Establece la lista de detalles del dispositivo electrónico.
     * @param deviceDetails La lista de detalles del dispositivo electrónico.
     */
    public void setDeviceDetails(List<DeviceDetail> deviceDetails) {
        this.deviceDetails = deviceDetails;
    }

    /**
     * Obtiene la lista de reparaciones asociadas al dispositivo electrónico.
     * @return La lista de reparaciones asociadas.
     */
    public List<Repair> getRepairElectronicDevices() {
        return repairElectronicDevices;
    }

    /**
     * Establece la lista de reparaciones asociadas al dispositivo electrónico.
     * @param repairElectronicDevices La lista de reparaciones asociadas.
     */
    public void setRepairElectronicDevices(List<Repair> repairElectronicDevices) {
        this.repairElectronicDevices = repairElectronicDevices;
    }

    /**
     * Obtiene el tipo de dispositivo electrónico.
     * @return El tipo de dispositivo electrónico.
     */
    public TypeElectronicDevice getTypeElectronicDevice() {
        return typeElectronicDevice;
    }

    /**
     * Establece el tipo de dispositivo electrónico.
     * @param typeElectronicDevice El tipo de dispositivo electrónico.
     */
    public void setTypeElectronicDevice(TypeElectronicDevice typeElectronicDevice) {
        this.typeElectronicDevice = typeElectronicDevice;
    }

    /**
     * Método `toString` que devuelve una representación textual de la entidad `ElectronicDevice`.
     * @return Una cadena con la representación del dispositivo electrónico.
     */
    @Override
    public String toString() {
        return "ElectronicDevice{" +
                "idElectronicDevice=" + idElectronicDevice +
                ", descriptionElectronicDevice='" + descriptionElectronicDevice + '\'' +
                ", idTypeElectronicDevice=" + idTypeElectronicDevice +
                '}';
    }
}
