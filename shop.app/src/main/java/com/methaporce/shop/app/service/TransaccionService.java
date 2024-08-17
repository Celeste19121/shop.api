package com.methaporce.shop.app.service;

import com.methaporce.shop.app.entities.Transaccion;
import com.methaporce.shop.app.repositorys.TransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class TransaccionService implements TransaccionServiceI {
    @Autowired
    TransaccionRepository transaccionRepository;

    @Override
    public Optional<Transaccion> obtenerTransaccionById(Long id) {
        return transaccionRepository.findById(id);
    }

    public Transaccion crearTransaccion(Transaccion transaccion) {
        return transaccionRepository.save(transaccion);
    }

}