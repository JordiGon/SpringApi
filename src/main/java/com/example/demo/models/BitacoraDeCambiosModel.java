package com.example.demo.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="bitacoradecambios")
public class BitacoraDeCambiosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true, name = "id_cambio")
    private Integer id_cambio;
    private LocalDateTime fechahora;
    private Integer id_transaccion_fk;
    private Integer id_cliente_fk;
    private Integer id_gasolinera_fk;
    private Integer id_status_fk;
    private Integer id_tipo_consumo_fk;
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
    public Integer getId_transaccion_fk() {
        return id_transaccion_fk;
    }
    public void setId_transaccion_fk(Integer id_transaccion_fk) {
        this.id_transaccion_fk = id_transaccion_fk;
    }
    public Integer getId_cliente_fk() {
        return id_cliente_fk;
    }
    public void setId_cliente_fk(Integer id_cliente_fk) {
        this.id_cliente_fk = id_cliente_fk;
    }
    public Integer getId_gasolinera_fk() {
        return id_gasolinera_fk;
    }
    public void setId_gasolinera_fk(Integer id_gasolinera_fk) {
        this.id_gasolinera_fk = id_gasolinera_fk;
    }
    public Integer getId_status_fk() {
        return id_status_fk;
    }
    public void setId_status_fk(Integer id_status_fk) {
        this.id_status_fk = id_status_fk;
    }
    public Integer getId_tipo_consumo_fk() {
        return id_tipo_consumo_fk;
    }
    public void setId_tipo_consumo_fk(Integer id_tipo_consumo_fk) {
        this.id_tipo_consumo_fk = id_tipo_consumo_fk;
    }
}
