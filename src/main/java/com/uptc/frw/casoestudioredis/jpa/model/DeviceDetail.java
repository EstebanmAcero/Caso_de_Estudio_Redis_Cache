package com.uptc.frw.casoestudioredis.jpa.model;

import jakarta.persistence.*;

/**
 * Representa los detalles de un dispositivo electrónico, incluyendo los componentes que lo conforman,
 * la cantidad y el precio de dichos componentes en el dispositivo. La clase está mapeada a la tabla
 * "APARATODETALLE" en la base de datos.
 */
@Entity
@Table(name = "APARATODETALLE")
public class DeviceDetail {

    /**
     * Identificador único del detalle del dispositivo. Es la clave primaria de la tabla.
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aparatoDetGen")
    @SequenceGenerator(name = "aparatoDetGen", sequenceName = "APARATODET_SEQ", allocationSize = 1)
    private long idDeviceDetail;

    /**
     * Identificador del dispositivo electrónico. Este campo está marcado como no insertable ni actualizable,
     * ya que se utiliza para establecer la relación entre esta entidad y la entidad `ElectronicDevice`.
     */
    @Column(name = "ID_APARATO", insertable = false, updatable = false)
    private long idElectronicDevice;

    /**
     * Identificador del componente asociado a este detalle del dispositivo. Este campo está marcado como no
     * insertable ni actualizable, ya que se usa para la relación con la entidad `Component`.
     */
    @Column(name = "ID_COMPONENTE", insertable = false, updatable = false)
    private long idComponent;

    /**
     * Cantidad de componentes que forman parte del dispositivo. Representa el número de componentes del
     * tipo especificado que están asociados al dispositivo electrónico.
     */
    @Column(name = "CANTIDAD")
    private long quantityDeviceDetail;

    /**
     * Precio del componente dentro del detalle del dispositivo. Este valor representa el precio de un
     * componente específico en el contexto del dispositivo.
     */
    @Column(name = "PRECIO")
    private long priceDeviceDetail;

    /**
     * Relación muchos a uno con la entidad `Component`. Un detalle del dispositivo está asociado a un componente específico.
     */
    @ManyToOne
    @JoinColumn(name = "ID_COMPONENTE")
    private Component component;

    /**
     * Relación muchos a uno con la entidad `ElectronicDevice`. Un detalle del dispositivo está asociado a un dispositivo electrónico.
     */
    @ManyToOne
    @JoinColumn(name = "ID_APARATO")
    private ElectronicDevice electronicDevice;

    /**
     * Constructor vacío requerido por JPA para la creación de instancias de la entidad.
     */
    public DeviceDetail() {
    }

    // Getters y setters

    /**
     * Obtiene el identificador del detalle del dispositivo.
     * @return El identificador del detalle del dispositivo.
     */
    public long getIdDeviceDetail() {
        return idDeviceDetail;
    }

    /**
     * Establece el identificador del detalle del dispositivo.
     * @param idDeviceDetail El identificador del detalle del dispositivo.
     */
    public void setIdDeviceDetail(long idDeviceDetail) {
        this.idDeviceDetail = idDeviceDetail;
    }

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
     * Obtiene la cantidad del componente en el detalle del dispositivo.
     * @return La cantidad de componentes.
     */
    public long getQuantityDeviceDetail() {
        return quantityDeviceDetail;
    }

    /**
     * Establece la cantidad de componentes en el detalle del dispositivo.
     * @param quantityDeviceDetail La cantidad de componentes.
     */
    public void setQuantityDeviceDetail(long quantityDeviceDetail) {
        this.quantityDeviceDetail = quantityDeviceDetail;
    }

    /**
     * Obtiene el precio del componente en el detalle del dispositivo.
     * @return El precio del componente.
     */
    public long getPriceDeviceDetail() {
        return priceDeviceDetail;
    }

    /**
     * Establece el precio del componente en el detalle del dispositivo.
     * @param priceDeviceDetail El precio del componente.
     */
    public void setPriceDeviceDetail(long priceDeviceDetail) {
        this.priceDeviceDetail = priceDeviceDetail;
    }

    /**
     * Obtiene el componente asociado a este detalle del dispositivo.
     * @return El componente asociado.
     */
    public Component getComponent() {
        return component;
    }

    /**
     * Establece el componente asociado a este detalle del dispositivo.
     * @param component El componente asociado.
     */
    public void setComponent(Component component) {
        this.component = component;
    }

    /**
     * Obtiene el dispositivo electrónico asociado a este detalle.
     * @return El dispositivo electrónico asociado.
     */
    public ElectronicDevice getElectronicDevice() {
        return electronicDevice;
    }

    /**
     * Establece el dispositivo electrónico asociado a este detalle.
     * @param electronicDevice El dispositivo electrónico asociado.
     */
    public void setElectronicDevice(ElectronicDevice electronicDevice) {
        this.electronicDevice = electronicDevice;
    }

    /**
     * Método `toString` que devuelve una representación textual de la entidad `DeviceDetail`.
     * @return Una cadena con la representación del detalle del dispositivo.
     */
    @Override
    public String toString() {
        return "DeviceDetail{" +
                "idDeviceDetail=" + idDeviceDetail +
                ", idElectronicDevice=" + idElectronicDevice +
                ", idComponent=" + idComponent +
                ", quantityDeviceDetail=" + quantityDeviceDetail +
                ", priceDeviceDetail=" + priceDeviceDetail +
                '}';
    }
}
