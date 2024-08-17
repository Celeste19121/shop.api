package com.methaporce.shop.app.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "pagos")
public class Transaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pago;
    @ManyToOne
    private Usuario comprador;
    private String producto;
    private String metodo_pago;
    private String fecha_pago;
    private Double monto_total;


    public Transaccion() {
    }

    public Transaccion(Long id_pago, Usuario comprador, String producto, String metodo_pago, String fecha_pago, Double monto_total) {
        this.id_pago = id_pago;
        this.comprador = comprador;
        this.producto = producto;
        this.metodo_pago = metodo_pago;
        this.fecha_pago = fecha_pago;
        this.monto_total = monto_total;
    }

    public Long getId_pago() {
        return id_pago;
    }

    public void setId_pago(Long id_pago) {
        this.id_pago = id_pago;
    }

    public Usuario getComprador() {
        return comprador;
    }

    public void setComprador(Usuario comprador) {
        this.comprador = comprador;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getMetodo_pago() {
        return metodo_pago;
    }

    public void setMetodo_pago(String metodo_pago) {
        this.metodo_pago = metodo_pago;
    }

    public String getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(String fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    public Double getMonto_total() {
        return monto_total;
    }

    public void setMonto_total(Double monto_total) {
        this.monto_total = monto_total;
    }

    @Override
    public String toString() {
        return "Transaccion{" +
                "id_pago=" + id_pago +
                ", comprador=" + comprador +
                ", producto='" + producto + '\'' +
                ", metodo_pago='" + metodo_pago + '\'' +
                ", fecha_pago='" + fecha_pago + '\'' +
                ", monto_total=" + monto_total +
                '}';
    }
}

