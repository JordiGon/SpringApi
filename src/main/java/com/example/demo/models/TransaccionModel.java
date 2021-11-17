package com.example.demo.models;

import java.sql.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="transaccion")
public class TransaccionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "id_transaccion")
    private Integer id_transaccion;
    private Date fecha;
    private Float volumen;
    private Float monto;
    @JsonIgnoreProperties({"transacciones", "tipo_de_cuenta", "vehiculos"})
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "id_cliente_fk")
    private ClienteModel cliente;
    @JsonIgnoreProperties({"transacciones", "vehiculos","empleadosRegistrados", })
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name= "id_gasolinera_fk")
    private GasolineraModel gasolinera;
    @JsonIgnoreProperties({"transacciones"})
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name="id_status_fk")
    private StatusTransaccionModel status;
    @JsonIgnoreProperties({"transacciones"})
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "tipo_consumo_fk")
    private TipoConsumoModel tipo_consumo;
    public StatusTransaccionModel getStatus() {
        return status;
    }
    public ClienteModel getCliente() {
        return cliente;
    }
    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }
    public GasolineraModel getGasolinera() {
        return gasolinera;
    }
    public void setGasolinera(GasolineraModel gasolinera) {
        this.gasolinera = gasolinera;
    }
    public TipoConsumoModel getTipo_consumo() {
        return tipo_consumo;
    }
    public void setTipo_consumo(TipoConsumoModel tipo_consumo) {
        this.tipo_consumo = tipo_consumo;
    }
    public void setStatus(StatusTransaccionModel status) {
        this.status = status;
    }
    public Integer getId_transaccion() {
        return id_transaccion;
    }
    public void setId_transaccion(Integer id_transaccion) {
        this.id_transaccion = id_transaccion;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public Float getVolumen() {
        return volumen;
    }
    public void setVolumen(Float volumen) {
        this.volumen = volumen;
    }
    public Float getMonto() {
        return monto;
    }
    public void setMonto(Float monto) {
        this.monto = monto;
    }
}
