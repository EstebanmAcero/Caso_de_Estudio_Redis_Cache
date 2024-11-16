package com.uptc.frw.casoestudioredis.jpa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

/**
 * Representa a un fabricante, incluyendo su nombre, dirección, teléfono, RIF y domicilio fiscal.
 * La clase mapea la tabla "FABRICANTE" en la base de datos.
 */
@Entity
@Table(name="FABRICANTE")
public class Manufacturer implements Serializable {

    /**
     * Identificador único del fabricante. Es la clave primaria de la tabla.
     */
    @Id
    @Column(name="ID_FABRICANTE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fabricanteGen")
    @SequenceGenerator(name = "fabricanteGen", sequenceName = "FABRICANTE_SEQ", allocationSize = 1)
    private long idManufacturer;

    /**
     * Nombre del fabricante.
     */
    @Column(name="NOMBRE")
    private String nameManufacturer;

    /**
     * Dirección del fabricante.
     */
    @Column(name="DIRECCION")
    private String addressManufacturer;

    /**
     * Teléfono del fabricante.
     */
    @Column(name="TELEFONO")
    private String phoneManufacturer;

    /**
     * RIF (Registro de Información Fiscal) del fabricante.
     */
    @Column(name="RIF")
    private String rifManufacturer;

    /**
     * Domicilio fiscal del fabricante.
     */
    @Column(name="DOMICILIOFISCAL")
    private String fiscalDomicileManufacturer;

    /**
     * Relación uno a muchos con la entidad `Component`. Un fabricante puede producir varios componentes.
     */
    @OneToMany(mappedBy = "manufacturer", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Component> components;

    /**
     * Constructor vacío requerido por JPA para la creación de instancias de la entidad.
     */
    public Manufacturer() {
    }

    // Getters y setters

    /**
     * Obtiene el identificador del fabricante.
     * @return El identificador del fabricante.
     */
    public long getIdManufacturer() {
        return idManufacturer;
    }

    /**
     * Establece el identificador del fabricante.
     * @param idManufacturer El identificador del fabricante.
     */
    public void setIdManufacturer(long idManufacturer) {
        this.idManufacturer = idManufacturer;
    }

    /**
     * Obtiene el nombre del fabricante.
     * @return El nombre del fabricante.
     */
    public String getNameManufacturer() {
        return nameManufacturer;
    }

    /**
     * Establece el nombre del fabricante.
     * @param nameManufacturer El nombre del fabricante.
     */
    public void setNameManufacturer(String nameManufacturer) {
        this.nameManufacturer = nameManufacturer;
    }

    /**
     * Obtiene la dirección del fabricante.
     * @return La dirección del fabricante.
     */
    public String getAddressManufacturer() {
        return addressManufacturer;
    }

    /**
     * Establece la dirección del fabricante.
     * @param addressManufacturer La dirección del fabricante.
     */
    public void setAddressManufacturer(String addressManufacturer) {
        this.addressManufacturer = addressManufacturer;
    }

    /**
     * Obtiene el teléfono del fabricante.
     * @return El teléfono del fabricante.
     */
    public String getPhoneManufacturer() {
        return phoneManufacturer;
    }

    /**
     * Establece el teléfono del fabricante.
     * @param phoneManufacturer El teléfono del fabricante.
     */
    public void setPhoneManufacturer(String phoneManufacturer) {
        this.phoneManufacturer = phoneManufacturer;
    }

    /**
     * Obtiene el RIF del fabricante.
     * @return El RIF del fabricante.
     */
    public String getRifManufacturer() {
        return rifManufacturer;
    }

    /**
     * Establece el RIF del fabricante.
     * @param rifManufacturer El RIF del fabricante.
     */
    public void setRifManufacturer(String rifManufacturer) {
        this.rifManufacturer = rifManufacturer;
    }

    /**
     * Obtiene el domicilio fiscal del fabricante.
     * @return El domicilio fiscal del fabricante.
     */
    public String getFiscalDomicileManufacturer() {
        return fiscalDomicileManufacturer;
    }

    /**
     * Establece el domicilio fiscal del fabricante.
     * @param fiscalDomicileManufacturer El domicilio fiscal del fabricante.
     */
    public void setFiscalDomicileManufacturer(String fiscalDomicileManufacturer) {
        this.fiscalDomicileManufacturer = fiscalDomicileManufacturer;
    }

    /**
     * Obtiene la lista de componentes asociados con el fabricante.
     * @return La lista de componentes asociados.
     */
    public List<Component> getComponents() {
        return components;
    }

    /**
     * Establece la lista de componentes asociados con el fabricante.
     * @param components La lista de componentes asociados.
     */
    public void setComponents(List<Component> components) {
        this.components = components;
    }

    /**
     * Método `toString` que devuelve una representación textual de la entidad `Manufacturer`.
     * @return Una cadena con la representación del fabricante.
     */
    @Override
    public String toString() {
        return "Manufacturer{" +
                "idManufacturer=" + idManufacturer +
                ", nameManufacturer='" + nameManufacturer + '\'' +
                ", addressManufacturer='" + addressManufacturer + '\'' +
                ", phoneManufacturer='" + phoneManufacturer + '\'' +
                ", rifManufacturer='" + rifManufacturer + '\'' +
                ", fiscalDomicileManufacturer='" + fiscalDomicileManufacturer + '\'' +
                '}';
    }
}
