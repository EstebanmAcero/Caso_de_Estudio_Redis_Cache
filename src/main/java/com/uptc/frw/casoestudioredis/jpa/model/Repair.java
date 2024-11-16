package com.uptc.frw.casoestudioredis.jpa.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import java.util.List;

/**
 * Representa una reparación de un dispositivo electrónico.
 * La clase mapea la tabla "REPARACION" en la base de datos.
 */
@Entity
@Table(name = "REPARACION")
public class Repair {

    /**
     * Identificador único de la reparación. Es la clave primaria de la tabla.
     */
    @Id
    @Column(name = "ID_REPARACION")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reparacionGen")
    @SequenceGenerator(name = "reparacionGen", sequenceName = "REPARACION_SEQ", allocationSize = 1)
    private long idRepair;

    /**
     * Fecha en que la reparación ingresó al sistema.
     */
    @Column(name = "FECHA_ENTRADA")
    private Date dateInRepair;

    /**
     * Fecha en que la reparación fue completada o entregada.
     */
    @Column(name = "FECHA_SALIDA")
    private Date dateOutRepair;

    /**
     * Descripción del problema que el dispositivo presenta.
     */
    @Column(name = "DESCRIPCION_PROBLEMA")
    private String descriptionProblem;

    /**
     * Identificador del dispositivo electrónico asociado a la reparación.
     */
    @Column(name = "ID_APARATO", insertable = false, updatable = false)
    private long idElectronicDevice;

    /**
     * Identificador del cliente que solicitó la reparación.
     */
    @Column(name = "ID_CLIENTE", insertable = false, updatable = false)
    private long idClient;

    /**
     * Relación muchos a uno con la entidad `ElectronicDevice`.
     * Un dispositivo electrónico puede tener muchas reparaciones.
     */
    @ManyToOne
    @JoinColumn(name = "ID_APARATO")
    private ElectronicDevice electronicDeviceRepair;

    /**
     * Relación muchos a uno con la entidad `Client`.
     * Un cliente puede tener muchas reparaciones.
     */
    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE")
    @JsonIgnore
    private Client clientRepair;

    /**
     * Relación uno a muchos con la entidad `ComponentRepair`.
     * Una reparación puede tener varios componentes reparados.
     */
    @OneToMany(mappedBy = "repairComponentKey")
    private List<ComponentRepair> componentsRepair;

    /**
     * Constructor vacío requerido por JPA para la creación de instancias de la entidad.
     */
    public Repair() {
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
     * Obtiene la fecha de entrada de la reparación.
     * @return La fecha de entrada de la reparación.
     */
    public Date getDateInRepair() {
        return dateInRepair;
    }

    /**
     * Establece la fecha de entrada de la reparación.
     * @param dateInRepair La fecha de entrada de la reparación.
     */
    public void setDateInRepair(Date dateInRepair) {
        this.dateInRepair = dateInRepair;
    }

    /**
     * Obtiene la fecha de salida de la reparación.
     * @return La fecha de salida de la reparación.
     */
    public Date getDateOutRepair() {
        return dateOutRepair;
    }

    /**
     * Establece la fecha de salida de la reparación.
     * @param dateOutRepair La fecha de salida de la reparación.
     */
    public void setDateOutRepair(Date dateOutRepair) {
        this.dateOutRepair = dateOutRepair;
    }

    /**
     * Obtiene la descripción del problema de la reparación.
     * @return La descripción del problema.
     */
    public String getDescriptionProblem() {
        return descriptionProblem;
    }

    /**
     * Establece la descripción del problema de la reparación.
     * @param descriptionProblem La descripción del problema.
     */
    public void setDescriptionProblem(String descriptionProblem) {
        this.descriptionProblem = descriptionProblem;
    }

    /**
     * Obtiene el identificador del dispositivo electrónico asociado a la reparación.
     * @return El identificador del dispositivo electrónico.
     */
    public long getIdElectronicDevice() {
        return idElectronicDevice;
    }

    /**
     * Establece el identificador del dispositivo electrónico asociado a la reparación.
     * @param idElectronicDevice El identificador del dispositivo electrónico.
     */
    public void setIdElectronicDevice(long idElectronicDevice) {
        this.idElectronicDevice = idElectronicDevice;
    }

    /**
     * Obtiene el identificador del cliente asociado a la reparación.
     * @return El identificador del cliente.
     */
    public long getIdClient() {
        return idClient;
    }

    /**
     * Establece el identificador del cliente asociado a la reparación.
     * @param idClient El identificador del cliente.
     */
    public void setIdClient(long idClient) {
        this.idClient = idClient;
    }

    /**
     * Obtiene el dispositivo electrónico asociado a la reparación.
     * @return El dispositivo electrónico asociado a la reparación.
     */
    public ElectronicDevice getElectronicDeviceRepair() {
        return electronicDeviceRepair;
    }

    /**
     * Establece el dispositivo electrónico asociado a la reparación.
     * @param electronicDeviceRepair El dispositivo electrónico asociado.
     */
    public void setElectronicDeviceRepair(ElectronicDevice electronicDeviceRepair) {
        this.electronicDeviceRepair = electronicDeviceRepair;
    }

    /**
     * Obtiene el cliente asociado a la reparación.
     * @return El cliente asociado a la reparación.
     */
    public Client getClientRepair() {
        return clientRepair;
    }

    /**
     * Establece el cliente asociado a la reparación.
     * @param clientRepair El cliente asociado a la reparación.
     */
    public void setClientRepair(Client clientRepair) {
        this.clientRepair = clientRepair;
    }

    /**
     * Obtiene los componentes asociados a la reparación.
     * @return La lista de componentes reparados.
     */
    public List<ComponentRepair> getComponentsRepair() {
        return componentsRepair;
    }

    /**
     * Establece los componentes asociados a la reparación.
     * @param componentsRepair La lista de componentes reparados.
     */
    public void setComponentsRepair(List<ComponentRepair> componentsRepair) {
        this.componentsRepair = componentsRepair;
    }

    /**
     * Método `toString` que devuelve una representación textual de la entidad `Repair`.
     * @return Una cadena con la representación de la reparación.
     */
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
