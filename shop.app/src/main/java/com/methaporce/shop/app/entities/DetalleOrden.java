package com.methaporce.shop.app.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "detallesorden")
public class DetalleOrden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id_detalle;
    private Integer cantidad;
    private Double precio;


    @ManyToOne
    private Orden orden;

    @ManyToOne
    private Producto producto;

    public DetalleOrden() {
    }

    public DetalleOrden(Long id_detalle, Integer cantidad, Double precio, Orden orden, Producto producto) {
        this.id_detalle = id_detalle;
        this.cantidad = cantidad;
        this.precio = precio;
        this.orden = orden;
        this.producto = producto;
    }

    public Long getId_detalle() {
        return id_detalle;
    }

    public void setId_detalle(Long id_detalle) {
        this.id_detalle = id_detalle;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "DetalleOrden{" +
                "id_detalle=" + id_detalle +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                ", orden=" + orden +
                ", producto=" + producto +
                '}';
    }
}
