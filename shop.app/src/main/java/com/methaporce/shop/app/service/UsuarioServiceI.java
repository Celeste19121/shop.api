package com.methaporce.shop.app.service;

import com.methaporce.shop.app.entities.Usuario;

import java.util.Optional;

public interface UsuarioServiceI {
    Iterable<Usuario> findAll();
    Usuario save(Usuario usuario);
    Optional<Usuario> findByUsername(String username);
    Optional<Usuario> obtenerUsuarioById(Long id);

}

