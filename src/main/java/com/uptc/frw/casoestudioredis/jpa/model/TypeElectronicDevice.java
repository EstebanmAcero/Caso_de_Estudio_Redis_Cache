package com.uptc.frw.casoestudioredis.jpa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

/**
 * Representa el tipo de un dispositivo electrónico.
 * La clase mapea la tabla "TIPOELECTRODOMESTICO" en la base de datos.
 * Un tipo de dispositivo puede tener subtipos (tipos padres e hijos) y estar asociado con varios dispositivos electrónicos.
 */
@Entity
@Table(name = "TIPOELECTRODOMESTICO")
public class TypeElectronicDevice {

    /**
     * Identificador único del tipo de dispositivo electrónico. Es la clave primaria de la tabla.
     */
    @Id
    @Column(name = "ID_TIPO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "typeDevicegen")
    @SequenceGenerator(name = "typeDevicegen", sequenceName = "TIPOELECTRO_SEQ", allocationSize = 1)
    private long idTypeElectronicDevice;

    /**
     * Nombre del tipo de dispositivo electrónico (ejemplo: "Teléfono", "Televisor").
     */
    @Column(name = "NOMBRE")
    private String nameElectronicDevice;

    /**
     * Características o descripción del tipo de dispositivo electrónico.
     */
    @Column(name = "CARACTERISTICAS")
    private String characteristicsElectronicDevice;

    /**
     * Identificador del tipo padre. Si el tipo de dispositivo tiene un tipo superior, este valor lo indica.
     */
    @Column(name = "TIPO_PADRE")
    private long typeElectronicDevice;

    /**
     * Relación uno a muchos con la entidad `ElectronicDevice`.
     * Un tipo de dispositivo puede estar asociado con varios dispositivos electrónicos.
     */
    @OneToMany(mappedBy = "typeElectronicDevice")
    @JsonIgnore
    private List<ElectronicDevice> electronicDevicesList;

    /**
     * Relación muchos a uno con la entidad `TypeElectronicDevice`.
     * Un tipo de dispositivo puede tener un tipo padre (más genérico).
     */
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "TIPO_PADRE", insertable = false, updatable = false)
    private TypeElectronicDevice parentTypeElectronicDevice;

    /**
     * Relación uno a muchos con la entidad `TypeElectronicDevice`.
     * Un tipo de dispositivo puede tener varios subtipos.
     */
    @OneToMany(mappedBy = "parentTypeElectronicDevice")
    @JsonIgnore
    private List<TypeElectronicDevice> typeElectronicDevicesList;

    /**
     * Constructor vacío requerido por JPA para la creación de instancias de la entidad.
     */
    public TypeElectronicDevice() {}

    // Getters y setters

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
     * Obtiene el nombre del tipo de dispositivo electrónico.
     * @return El nombre del tipo de dispositivo.
     */
    public String getNameElectronicDevice() {
        return nameElectronicDevice;
    }

    /**
     * Establece el nombre del tipo de dispositivo electrónico.
     * @param nameElectronicDevice El nombre del tipo de dispositivo.
     */
    public void setNameElectronicDevice(String nameElectronicDevice) {
        this.nameElectronicDevice = nameElectronicDevice;
    }

    /**
     * Obtiene las características del tipo de dispositivo electrónico.
     * @return Las características del tipo de dispositivo.
     */
    public String getCharacteristicsElectronicDevice() {
        return characteristicsElectronicDevice;
    }

    /**
     * Establece las características del tipo de dispositivo electrónico.
     * @param characteristicsElectronicDevice Las características del tipo de dispositivo.
     */
    public void setCharacteristicsElectronicDevice(String characteristicsElectronicDevice) {
        this.characteristicsElectronicDevice = characteristicsElectronicDevice;
    }

    /**
     * Obtiene el identificador del tipo de dispositivo padre (si existe).
     * @return El identificador del tipo de dispositivo padre.
     */
    public long getTypeElectronicDevice() {
        return typeElectronicDevice;
    }

    /**
     * Establece el identificador del tipo de dispositivo padre (si existe).
     * @param typeElectronicDevice El identificador del tipo de dispositivo padre.
     */
    public void setTypeElectronicDevice(long typeElectronicDevice) {
        this.typeElectronicDevice = typeElectronicDevice;
    }

    /**
     * Obtiene la lista de dispositivos electrónicos asociados con este tipo de dispositivo.
     * @return La lista de dispositivos electrónicos asociados.
     */
    public List<ElectronicDevice> getElectronicDevicesList() {
        return electronicDevicesList;
    }

    /**
     * Establece la lista de dispositivos electrónicos asociados con este tipo de dispositivo.
     * @param electronicDevicesList La lista de dispositivos electrónicos asociados.
     */
    public void setElectronicDevicesList(List<ElectronicDevice> electronicDevicesList) {
        this.electronicDevicesList = electronicDevicesList;
    }

    /**
     * Obtiene el tipo de dispositivo padre (si existe).
     * @return El tipo de dispositivo padre.
     */
    public TypeElectronicDevice getParentTypeElectronicDevice() {
        return parentTypeElectronicDevice;
    }

    /**
     * Establece el tipo de dispositivo padre (si existe).
     * @param parentTypeElectronicDevice El tipo de dispositivo padre.
     */
    public void setParentTypeElectronicDevice(TypeElectronicDevice parentTypeElectronicDevice) {
        this.parentTypeElectronicDevice = parentTypeElectronicDevice;
    }

    /**
     * Obtiene la lista de subtipos asociados a este tipo de dispositivo.
     * @return La lista de subtipos de dispositivo electrónico.
     */
    public List<TypeElectronicDevice> getTypeElectronicDevicesList() {
        return typeElectronicDevicesList;
    }

    /**
     * Establece la lista de subtipos asociados a este tipo de dispositivo.
     * @param typeElectronicDevicesList La lista de subtipos de dispositivo electrónico.
     */
    public void setTypeElectronicDevicesList(List<TypeElectronicDevice> typeElectronicDevicesList) {
        this.typeElectronicDevicesList = typeElectronicDevicesList;
    }

    /**
     * Método `toString` que devuelve una representación textual de la entidad `TypeElectronicDevice`.
     * @return Una cadena con la representación del tipo de dispositivo electrónico.
     */
    @Override
    public String toString() {
        return "TypeElectronicDevice{" +
                "idTypeElectronicDevice=" + idTypeElectronicDevice +
                ", nameElectronicDevice='" + nameElectronicDevice + '\'' +
                ", characteristicsElectronicDevice='" + characteristicsElectronicDevice + '\'' +
                ", typeElectronicDevice=" + typeElectronicDevice +
                '}';
    }
}
