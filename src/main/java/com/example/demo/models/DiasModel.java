package com.example.demo.models;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="dias")
public class DiasModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "id_dias")
    private Integer id_dias;
    private String descripcion;
    @JsonIgnoreProperties({"dia","gasolineras"})
    @OneToMany(mappedBy = "dia", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<DiasConsumoModel> restringidos;
    public Integer getId_dias() {
        return id_dias;
    }
    public Set<DiasConsumoModel> getRestringidos() {
        return restringidos;
    }
    public void setRestringidos(Set<DiasConsumoModel> restringidos) {
        this.restringidos = restringidos;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setId_dias(Integer id_dias) {
        this.id_dias = id_dias;
    }
}
