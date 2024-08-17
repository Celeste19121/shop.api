package com.methaporce.shop.app.service;

import com.methaporce.shop.app.entities.Orden;
import com.methaporce.shop.app.entities.Usuario;

import java.util.List;
import java.util.Optional;

public interface OrdenServiceI {
    List<Orden> findAll();
    Optional<Orden> findById(Integer id);
    Orden save (Orden orden);
    String generarNumeroOrden();
    List<Orden> findByUsuario (Usuario usuario);
}