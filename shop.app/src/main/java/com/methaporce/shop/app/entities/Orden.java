package com.methaporce.shop.app.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ordenes")
public class Orden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_orden;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    @OneToMany(mappedBy = "orden")
    private List<DetalleOrden> detalle;
    private String numero;
    private Date orden_fecha;
    @Column(name = "total")
    private Double total;

    public Orden() {
    }

    public Orden(Long id_orden, Usuario usuario, List<DetalleOrden> detalle, String numero, Date orden_fecha, Double total) {
        this.id_orden = id_orden;
        this.usuario = usuario;
        this.detalle = detalle;
        this.numero = numero;
        this.orden_fecha = orden_fecha;
        this.total = total;
    }

    public Long getId_orden() {
        return id_orden;
    }

    public void setId_orden(Long id_orden) {
        this.id_orden = id_orden;
    }

    public Usuario getComprador() {
        return usuario;
    }

    public void setComprador(Usuario comprador) {
        this.usuario = comprador;
    }

    public List<DetalleOrden> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<DetalleOrden> detalle) {
        this.detalle = detalle;
    }

    public String getNumero() {
        return numero;
    }

    public void setEstado(String numero) {
        this.numero = numero;
    }

    public Date getOrden_fecha() {
        return orden_fecha;
    }

    public void setOrden_fecha(Date orden_fecha) {
        this.orden_fecha = orden_fecha;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Orden{" +
                "id_orden=" + id_orden +
                ", comprador=" + usuario +
                ", detalle=" + detalle +
                ", estado='" + numero + '\'' +
                ", orden_fecha=" + orden_fecha +
                ", total=" + total +
                '}';
    }
}

