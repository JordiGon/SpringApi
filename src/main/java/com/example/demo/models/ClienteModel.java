package com.example.demo.models;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "clientes")
public class ClienteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "id_cliente")
    private Integer id_cliente;
    private String nombre_cliente;
    private String correo;
    private String password;
    @JsonIgnoreProperties("cliente")
    @ManyToOne(fetch= FetchType.EAGER ,optional = true)
    @JoinColumn(name="id_tipo_de_cuenta_fk")
    private TipoCuentaModel tipo_de_cuenta; 
    @JsonIgnoreProperties("cliente")
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<VehiculoModel> vehiculos;
    @JsonIgnoreProperties({"gasolinera", "status", "tipo_consumo", "cliente"})
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "cliente")
    private Set<TransaccionModel> transacciones;
    public Set<TransaccionModel> getTransacciones() {
        return transacciones;
    }
    public void setTransacciones(Set<TransaccionModel> transacciones) {
        this.transacciones = transacciones;
    }
    public Integer getId_cliente() {
        return id_cliente;
    }
    public Set<VehiculoModel> getVehiculos() {
        return vehiculos;
    }
    public void setVehiculos(Set<VehiculoModel> vehiculos) {
        this.vehiculos = vehiculos;
    }
    public TipoCuentaModel getTipo_de_cuenta() {
        return tipo_de_cuenta;
    }
    public void setTipo_de_cuenta(TipoCuentaModel tipo_de_cuenta) {
        this.tipo_de_cuenta = tipo_de_cuenta;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getNombre_cliente() {
        return nombre_cliente;
    }
    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }
    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }


}
