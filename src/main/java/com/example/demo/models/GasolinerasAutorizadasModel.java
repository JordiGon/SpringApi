package com.example.demo.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="gasolinerasautorizadas")
public class GasolinerasAutorizadasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_autorizadas", nullable = false, unique = true)
    private Integer id_autorizadas;
    @JsonIgnoreProperties({"vehiculos", "empleadosRegistrados","cliente","transacciones"})
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "id_gasolinera_fk")
    private GasolineraModel gasolinera;
    @JsonIgnoreProperties({"gasolineras", "diascons", "restriccion", "cliente"})
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name="id_vehiculo_fk")
    private VehiculoModel vehiculo;
    public Integer getId_autorizadas() {
        return id_autorizadas;
    }
    public GasolineraModel getGasolinera() {
        return gasolinera;
    }
    public void setGasolinera(GasolineraModel gasolinera) {
        this.gasolinera = gasolinera;
    }
    public VehiculoModel getVehiculo() {
        return vehiculo;
    }
    public void setVehiculo(VehiculoModel vehiculo) {
        this.vehiculo = vehiculo;
    }
    public void setId_autorizadas(Integer id_autorizadas) {
        this.id_autorizadas = id_autorizadas;
    }
}
