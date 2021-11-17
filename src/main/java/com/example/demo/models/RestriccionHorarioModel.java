package com.example.demo.models;

import java.sql.Time;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="restriccionhorario")
public class RestriccionHorarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "id_horario_consumo")
    private Integer id_horario_consumo;
    private Time hora_fin;
    private Time hora_inicio;
    @JsonIgnoreProperties({"restriccion", "diascons", "gasolineras"})
    @OneToMany(mappedBy = "restriccion", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<VehiculoModel> vehiculosrest;
    public Integer getId_horario_consumo() {
        return id_horario_consumo;
    }
    public Set<VehiculoModel> getvehiculosrest() {
        return vehiculosrest;
    }
    public void setvehiculosrest(Set<VehiculoModel> vehiculosrest) {
        this.vehiculosrest = vehiculosrest;
    }
    public Time getHora_inicio() {
        return hora_inicio;
    }
    public void setHora_inicio(Time hora_inicio) {
        this.hora_inicio = hora_inicio;
    }
    public Time getHora_fin() {
        return hora_fin;
    }
    public void setHora_fin(Time hora_fin) {
        this.hora_fin = hora_fin;
    }
    public void setId_horario_consumo(Integer id_horario_consumo) {
        this.id_horario_consumo = id_horario_consumo;
    }
}
