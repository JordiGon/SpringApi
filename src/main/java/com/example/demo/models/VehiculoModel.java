package com.example.demo.models;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table( name="Vehiculos")
public class VehiculoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "id_vehiculos")
    private Integer id_vehiculos;
    private String descripcion_vehiculo;
    private Integer kilometraje;
    private String placa;
    @JsonIgnoreProperties("vehiculodia")
    @OneToMany(mappedBy = "vehiculodia" ,fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<DiasConsumoModel> diascons;
    @JsonIgnoreProperties("vehiculosrest")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name ="restriccion_horario_id_fk", nullable = true)
    private RestriccionHorarioModel restriccion;
    @JsonIgnoreProperties({"vehiculos","tipo_de_cuenta"})
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name="id_cliente_fk", nullable = true)
    private ClienteModel cliente;
    @JsonIgnoreProperties("vehiculo")
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "vehiculo")
    private Set<GasolinerasAutorizadasModel> gasolineras;

    public Integer getId_vehiculos() {
        return id_vehiculos;
    }
    
    public Set<GasolinerasAutorizadasModel> getGasolineras() {
        return gasolineras;
    }

    public void setGasolineras(Set<GasolinerasAutorizadasModel> gasolineras) {
        this.gasolineras = gasolineras;
    }

    public Set<DiasConsumoModel> getDiascons() {
        return diascons;
    }

    public void setDiascons(Set<DiasConsumoModel> diascons) {
        this.diascons = diascons;
    }

    public RestriccionHorarioModel getRestriccion() {
        return restriccion;
    }

    public void setRestriccion(RestriccionHorarioModel restriccion) {
        this.restriccion = restriccion;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public ClienteModel getCliente() {
        return cliente;
    }
    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }
    public Integer getKilometraje() {
        return kilometraje;
    }
    public void setKilometraje(Integer kilometraje) {
        this.kilometraje = kilometraje;
    }
    public String getDescripcion_vehiculo() {
        return descripcion_vehiculo;
    }
    public void setDescripcion_vehiculo(String descripcion_vehiculo) {
        this.descripcion_vehiculo = descripcion_vehiculo;
    }
    public void setId_vehiculos(Integer id_vehiculos) {
        this.id_vehiculos = id_vehiculos;
    }
    
}
