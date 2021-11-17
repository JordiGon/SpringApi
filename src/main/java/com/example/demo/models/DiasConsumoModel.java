package com.example.demo.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="diasconsumo")
public class DiasConsumoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "id_restriccion_dias")
    private Integer id_restriccion_dias;
    @JsonIgnoreProperties({"diascons", "restriccion", "gasolineras"})
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name= "id_vehiculo_fk")
    private VehiculoModel vehiculodia;
    @JsonIgnoreProperties("restringidos")
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name="id_dia_fk")
    private DiasModel dia;
    public Integer getId_restriccion_dias() {
        return id_restriccion_dias;
    }
    public VehiculoModel getVehiculodia() {
        return vehiculodia;
    }
    public void setVehiculodia(VehiculoModel vehiculodia) {
        this.vehiculodia = vehiculodia;
    }
    public DiasModel getDia() {
        return dia;
    }
    public void setDia(DiasModel dia) {
        this.dia = dia;
    }
    public void setId_restriccion_dias(Integer id_restriccion_dias) {
        this.id_restriccion_dias = id_restriccion_dias;
    }
}
