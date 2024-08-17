package com.methaporce.shop.app.service;

import com.methaporce.shop.app.entities.DetalleOrden;
import com.methaporce.shop.app.repositorys.DetalleOrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleOrdenService implements DetalleOrdenServiceI{
    @Autowired
    private DetalleOrdenRepository detalleOrdenRepository;
    @Override
    public DetalleOrden save(DetalleOrden detalleOrden){
        return detalleOrdenRepository.save(detalleOrden);
    }
}