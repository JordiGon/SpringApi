package com.example.demo.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="empleados")
public class EmpleadosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleados", unique = true, nullable = false)
    private Integer id_empleados;
    private String nombre_empleado;
    private String correo;
    private String password;
    //private Integer id_gasolinera_fk;
    @JsonIgnoreProperties({"empleadosRegistrados","vehiculos"})
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "id_gasolinera_fk")
    private GasolineraModel sede;
    public Integer getId_empleados() {
        return id_empleados;
    }
    public GasolineraModel getSede() {
        return sede;
    }
    public void setSede(GasolineraModel sede) {
        this.sede = sede;
    }
    public void setId_empleados(Integer id_empleados) {
        this.id_empleados = id_empleados;
    }
    public String getNombre_empleado() {
        return nombre_empleado;
    }
    public void setNombre_empleado(String nombre_empleado) {
        this.nombre_empleado = nombre_empleado;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
