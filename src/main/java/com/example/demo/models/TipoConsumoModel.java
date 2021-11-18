package com.example.demo.models;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tipoconsumo")
public class TipoConsumoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true, name="id_tipo_consumo")
    private Integer id_tipo_consumo;
    private Float precio_galon;
    private String nombre_producto;
    @JsonIgnoreProperties({"gasolinera", "status", "tipo_consumo", "cliente", "cambios"})
    @OneToMany(mappedBy = "tipo_consumo", fetch = FetchType.EAGER)
    private Set<TransaccionModel> transacciones;
    @JsonIgnoreProperties("producto")
    @OneToMany(mappedBy = "producto", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<BitacoraDeCambiosModel> cambios;
    public Set<TransaccionModel> getTransacciones() {
        return transacciones;
    }
    public Set<BitacoraDeCambiosModel> getCambios() {
        return cambios;
    }
    public void setCambios(Set<BitacoraDeCambiosModel> cambios) {
        this.cambios = cambios;
    }
    public void setTransacciones(Set<TransaccionModel> transacciones) {
        this.transacciones = transacciones;
    }
    public Integer getId_tipo_consumo() {
        return id_tipo_consumo;
    }
    public void setId_tipo_consumo(Integer id_tipo_consumo) {
        this.id_tipo_consumo = id_tipo_consumo;
    }
    public Float getPrecio_galon() {
        return precio_galon;
    }
    public void setPrecio_galon(Float precio_galon) {
        this.precio_galon = precio_galon;
    }
    public String getNombre_producto() {
        return nombre_producto;
    }
    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }
}
