package com.methaporce.shop.app.service;

import com.methaporce.shop.app.entities.Usuario;
import com.methaporce.shop.app.repositorys.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements UsuarioServiceI {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder encoder;

    public Iterable<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario save(Usuario usuario) {
        Optional<Usuario> oUser = this.usuarioRepository.findByUsername(usuario.getUsername());
        if (oUser.isPresent()) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    String.format("User '%s' already exists", usuario.getUsername())
            );
        }
        String passwordEncode = encoder.encode(usuario.getPassword());
        usuario.setPassword(passwordEncode);
        return this.usuarioRepository.save(usuario);
    }

    @Override
    public Optional<Usuario> obtenerUsuarioById(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Optional<Usuario> findByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }
}

