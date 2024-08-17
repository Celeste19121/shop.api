package com.methaporce.shop.app.service;

import com.methaporce.shop.app.entities.Transaccion;

import java.util.Optional;

public interface TransaccionServiceI {
    Optional<Transaccion> obtenerTransaccionById(Long id);
    Transaccion crearTransaccion(Transaccion transaccion);

}