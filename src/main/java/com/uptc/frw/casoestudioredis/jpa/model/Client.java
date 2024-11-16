package com.uptc.frw.casoestudioredis.jpa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

/**
 * Representa a un cliente en el sistema.
 * Esta clase está anotada con JPA para mapear la tabla CLIENTE de la base de datos.
 * También es serializable para poder ser transferida a través de redes o almacenada.
 *
 * La relación de la entidad Client con Repair es de uno a muchos, donde un cliente
 * puede tener múltiples reparaciones asociadas.
 */
@Entity
@Table(name  = "CLIENTE")
public class Client implements Serializable {
    /**
     * El identificador único del cliente. Este campo está mapeado a la columna "ID_CLIENTE".
     * Se genera automáticamente mediante una secuencia.
     */
    @Id
    @Column(name = "ID_CLIENTE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clientGen")
    @SequenceGenerator(name = "clientGen", sequenceName = "CLIENTE_SEQ", allocationSize = 1)
    private long idClient;

    /**
     * El nombre del cliente. Está mapeado a la columna "NOMBRE".
     */
    @Column(name = "NOMBRE")
    private String nameClient;

    /**
     * El apellido del cliente. Está mapeado a la columna "APELLIDO".
     */
    @Column(name = "APELLIDO")
    private String lastNameClient;

    /**
     * La dirección del cliente. Está mapeada a la columna "DIRECCION".
     */
    @Column(name = "DIRECCION")
    private String addressClient;

    /**
     * El teléfono del cliente. Está mapeado a la columna "TELEFONO".
     */
    @Column(name = "TELEFONO")
    private String phoneClient;

    /**
     * El correo electrónico del cliente. Está mapeado a la columna "EMAIL".
     */
    @Column(name = "EMAIL")
    private String emailClient;

    /**
     * Relación de uno a muchos entre Client y Repair.
     * Un cliente puede tener múltiples reparaciones.
     * La relación es mapeada por la propiedad "clientRepair" en la entidad Repair.
     * El atributo se carga de manera EAGER, es decir, se carga inmediatamente cuando se obtiene un cliente.
     */
    @OneToMany(mappedBy = "clientRepair", fetch = FetchType.EAGER)
    @JsonIgnore // Ignora este atributo cuando se serializa a JSON (evita un bucle infinito).
    private List<Repair> repairClient;

    /**
     * Constructor vacío para JPA.
     */
    public Client() {}

    /**
     * Obtiene el ID del cliente.
     * @return El identificador único del cliente.
     */
    public long getIdClient() {
        return idClient;
    }

    /**
     * Establece el ID del cliente.
     * @param idClient El identificador único del cliente.
     */
    public void setIdClient(long idClient) {
        this.idClient = idClient;
    }

    /**
     * Obtiene el nombre del cliente.
     * @return El nombre del cliente.
     */
    public String getNameClient() {
        return nameClient;
    }

    /**
     * Establece el nombre del cliente.
     * @param nameClient El nombre del cliente.
     */
    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    /**
     * Obtiene el apellido del cliente.
     * @return El apellido del cliente.
     */
    public String getLastNameClient() {
        return lastNameClient;
    }

    /**
     * Establece el apellido del cliente.
     * @param lastNameClient El apellido del cliente.
     */
    public void setLastNameClient(String lastNameClient) {
        this.lastNameClient = lastNameClient;
    }

    /**
     * Obtiene la dirección del cliente.
     * @return La dirección del cliente.
     */
    public String getAddressClient() {
        return addressClient;
    }

    /**
     * Establece la dirección del cliente.
     * @param addressClient La dirección del cliente.
     */
    public void setAddressClient(String addressClient) {
        this.addressClient = addressClient;
    }

    /**
     * Obtiene el teléfono del cliente.
     * @return El teléfono del cliente.
     */
    public String getPhoneClient() {
        return phoneClient;
    }

    /**
     * Establece el teléfono del cliente.
     * @param phoneClient El teléfono del cliente.
     */
    public void setPhoneClient(String phoneClient) {
        this.phoneClient = phoneClient;
    }

    /**
     * Obtiene el correo electrónico del cliente.
     * @return El correo electrónico del cliente.
     */
    public String getEmailClient() {
        return emailClient;
    }

    /**
     * Establece el correo electrónico del cliente.
     * @param emailClient El correo electrónico del cliente.
     */
    public void setEmailClient(String emailClient) {
        this.emailClient = emailClient;
    }

    /**
     * Obtiene la lista de reparaciones asociadas al cliente.
     * @return La lista de reparaciones.
     */
    public List<Repair> getRepairClient() {
        return repairClient;
    }

    /**
     * Establece la lista de reparaciones asociadas al cliente.
     * @param repairClient La lista de reparaciones.
     */
    public void setRepairClient(List<Repair> repairClient) {
        this.repairClient = repairClient;
    }

    /**
     * Método toString que proporciona una representación textual del objeto Client.
     *
     * @return Una cadena de texto representando el cliente.
     */
    @Override
    public String toString() {
        return "Client{" +
                "idClient=" + idClient +
                ", nameClient='" + nameClient + '\'' +
                ", lastNameClient='" + lastNameClient + '\'' +
                ", addressClient='" + addressClient + '\'' +
                ", phoneClient='" + phoneClient + '\'' +
                ", emailClient='" + emailClient + '\'' +
                '}';
    }
}
