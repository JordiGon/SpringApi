package com.example.demo.models;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "gasolinera")
public class GasolineraModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_gasolinera", nullable = false , unique = true)
    private Integer id_gasolinera;
    private String direccion;
    private String nombre;
    @JsonIgnoreProperties({"gasolinera","empleadosRegistrados","cliente"})
    @OneToMany(mappedBy = "gasolinera", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<GasolinerasAutorizadasModel> vehiculos;
    @JsonIgnoreProperties("sede")
    @OneToMany(mappedBy = "sede", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<EmpleadosModel> empleadosRegistrados;
    @JsonIgnoreProperties({"gasolinera", "status", "tipo_consumo", "cliente"})
    @OneToMany(mappedBy = "gasolinera", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<TransaccionModel> transacciones;
    public Integer getId_gasolinera() {
        return id_gasolinera;
    }
    public Set<TransaccionModel> getTransacciones() {
        return transacciones;
    }
    public void setTransacciones(Set<TransaccionModel> transacciones) {
        this.transacciones = transacciones;
    }
    public Set<EmpleadosModel> getEmpleadosRegistrados() {
        return empleadosRegistrados;
    }
    public void setEmpleadosRegistrados(Set<EmpleadosModel> empleadosRegistrados) {
        this.empleadosRegistrados = empleadosRegistrados;
    }
    public void setId_gasolinera(Integer id_gasolinera) {
        this.id_gasolinera = id_gasolinera;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Set<GasolinerasAutorizadasModel> getVehiculos() {
        return vehiculos;
    }
    public void setVehiculos(Set<GasolinerasAutorizadasModel> vehiculos) {
        this.vehiculos = vehiculos;
    }
}
