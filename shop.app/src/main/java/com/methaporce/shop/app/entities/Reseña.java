package com.methaporce.shop.app.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Reseña {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    private int calificacion;
    private String comentario;
    private LocalDateTime fechaReseña;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Producto getProducto() {
        return producto;
    }

    public Reseña() {
    }

    public Reseña(Long id, Producto producto, Usuario usuario, int calificacion, String comentario, LocalDateTime fechaReseña) {
        this.id = id;
        this.producto = producto;
        this.usuario = usuario;
        this.calificacion = calificacion;
        this.comentario = comentario;
        this.fechaReseña = fechaReseña;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDateTime getFechaReseña() {
        return fechaReseña;
    }

    public void setFechaReseña(LocalDateTime fechaReseña) {
        this.fechaReseña = fechaReseña;
    }

    @Override
    public String toString() {
        return "Reseña{" +
                "id=" + id +
                ", producto=" + producto +
                ", usuario=" + usuario +
                ", calificacion=" + calificacion +
                ", comentario='" + comentario + '\'' +
                ", fechaReseña=" + fechaReseña +
                '}';
    }
}

