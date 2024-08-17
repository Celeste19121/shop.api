package com.methaporce.shop.app.service;

import com.methaporce.shop.app.entities.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoServiceI {
    List<Producto> obtenerTodosLosProductos();
    Optional<Producto> obtenerProductoById(Long id);
    Producto agregarProducto(Producto producto);
    public void delete(Integer id);
    public List<Producto> findAll();
}

