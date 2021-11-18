package com.example.demo.models;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="statustransaction")
public class StatusTransaccionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true, name="id_status")
    private Integer id_status;
    private String status;
    @JsonIgnoreProperties({"gasolinera", "status", "tipo_consumo", "cliente","cambios"})
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "status", cascade = CascadeType.ALL)
    private Set<TransaccionModel> transacciones;
    @JsonIgnoreProperties({"status"})
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "status")
    private Set<BitacoraDeCambiosModel> cambios;
    public Integer getId_status() {
        return id_status;
    }
    public Set<BitacoraDeCambiosModel> getCambios() {
        return cambios;
    }
    public void setCambios(Set<BitacoraDeCambiosModel> cambios) {
        this.cambios = cambios;
    }
    public Set<TransaccionModel> getTransacciones() {
        return transacciones;
    }
    public void setTransacciones(Set<TransaccionModel> transacciones) {
        this.transacciones = transacciones;
    }
    public void setId_status(Integer id_status) {
        this.id_status = id_status;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    
}
