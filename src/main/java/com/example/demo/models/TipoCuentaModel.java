    package com.example.demo.models;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tipodecuenta")
public class TipoCuentaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "id_tipo_de_cuenta")
    private Integer id_tipo_de_cuenta;
    private String descripcion; 
    @JsonIgnoreProperties({"tipo_de_cuenta", "vehiculos"})
    @OneToMany(mappedBy = "tipo_de_cuenta", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<ClienteModel> cliente;
    public Integer getId_tipo_de_cuenta() {
        return id_tipo_de_cuenta;
    }
    public Set<ClienteModel> getCliente() {
        return cliente;
    }
    public void setCliente(Set<ClienteModel> cliente) {
        this.cliente = cliente;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setId_tipo_de_cuenta(Integer id_tipo_de_cuenta) {
        this.id_tipo_de_cuenta = id_tipo_de_cuenta;
    }
}
