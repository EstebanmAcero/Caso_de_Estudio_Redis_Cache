package com.uptc.frw.casoestudioredis.jpa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name  = "CLIENTE")
public class Client implements Serializable {
    @Id
    @Column(name = "ID_CLIENTE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "clientGen")
    @SequenceGenerator(name = "clientGen",sequenceName = "CLIENTE_SEQ",allocationSize = 1)
    private long idClient;
    @Column(name = "NOMBRE")
    private String nameClient;
    @Column(name = "APELLIDO")
    private String lastNameClient;
    @Column(name = "DIRECCION")
    private String addressClient;
    @Column(name = "TELEFONO")
    private String phoneClient;
    @Column(name = "EMAIL")
    private String emailClient;
    @OneToMany(mappedBy = "clientRepair", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Repair> repairClient;
    public Client() {}

    public long getIdClient() {
        return idClient;
    }

    public void setIdClient(long idClient) {
        this.idClient = idClient;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public String getLastNameClient() {
        return lastNameClient;
    }

    public void setLastNameClient(String lastNameClient) {
        this.lastNameClient = lastNameClient;
    }

    public String getAddressClient() {
        return addressClient;
    }

    public void setAddressClient(String addressClient) {
        this.addressClient = addressClient;
    }

    public String getPhoneClient() {
        return phoneClient;
    }

    public void setPhoneClient(String phoneClient) {
        this.phoneClient = phoneClient;
    }

    public String getEmailClient() {
        return emailClient;
    }

    public void setEmailClient(String emailClient) {
        this.emailClient = emailClient;
    }

    public List<Repair> getRepairClient() {
        return repairClient;
    }

    public void setRepairClient(List<Repair> repairClient) {
        this.repairClient = repairClient;
    }

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
