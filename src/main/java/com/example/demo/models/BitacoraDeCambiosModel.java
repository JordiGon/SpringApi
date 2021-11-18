package com.example.demo.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

@Entity
@Table(name="bitacoradecambios")
public class BitacoraDeCambiosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true, name = "id_cambio")
    private Integer id_cambio;
    private LocalDateTime fechahora;
//    private Integer id_transaccion_fk;   
    @JsonIgnoreProperties({"cambios", "cliente", "gasolinera", "status", "tipo_consumo"})
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name="id_transaccion_fk")
    private TransaccionModel transaccion;
    public TransaccionModel getTransaccion() {
        return transaccion;
    }
    public TipoConsumoModel getProducto() {
        return producto;
    }
    public void setProducto(TipoConsumoModel producto) {
        this.producto = producto;
    }
    public StatusTransaccionModel getStatus() {
        return status;
    }
    public void setStatus(StatusTransaccionModel status) {
        this.status = status;
    }
    public void setTransaccion(TransaccionModel transaccion) {
        this.transaccion = transaccion;
    }
    //private Integer id_cliente_fk;
    @JsonIgnoreProperties({"cambios","vehiculos", "transacciones", "tipo_de_cuenta"})
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name="id_cliente_fk")
    private ClienteModel cliente;
    //private Integer id_gasolinera_fk;
    @JsonIgnoreProperties({"cambios", "empleadosRegistrados", "vehiculos", "transacciones"})
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name ="id_gasolinera_fk")
    private GasolineraModel gasolinera;
    public GasolineraModel getGasolinera() {
        return gasolinera;
    }
    public void setGasolinera(GasolineraModel gasolinera) {
        this.gasolinera = gasolinera;
    }
    //private Integer id_status_fk;
    @JsonIgnoreProperties({"cambios", "transacciones"})
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name="id_status_fk")
    private StatusTransaccionModel status;
    //private Integer id_tipo_consumo_fk;
    @JsonIgnoreProperties({"cambios","transacciones"})
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name="id_tipo_consumo_fk")
    private TipoConsumoModel producto;
    public ClienteModel getCliente() {
        return cliente;
    }
    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }
    
    public Integer getId_cambio() {
        return id_cambio;
    }
    public void setId_cambio(Integer id_cambio) {
        this.id_cambio = id_cambio;
    }
    public LocalDateTime getFechahora() {
        return fechahora;
    }
    public void setFechahora(LocalDateTime fechahora) {
        this.fechahora = fechahora;
    }
}
