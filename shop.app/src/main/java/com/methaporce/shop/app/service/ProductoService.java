package com.methaporce.shop.app.service;

import com.methaporce.shop.app.entities.Producto;
import com.methaporce.shop.app.repositorys.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService implements ProductoServiceI {
    @Autowired
    ProductoRepository productoRepository;


    @Override
    public List<Producto> obtenerTodosLosProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Optional<Producto> obtenerProductoById(Long id) {
        return productoRepository.findById(id);
    }

    @Override
    public Producto agregarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Producto> findAll() {
        return null;
    }
}


