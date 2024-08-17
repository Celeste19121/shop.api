package com.methaporce.shop.app.service;

import com.methaporce.shop.app.entities.Producto;
import com.methaporce.shop.app.entities.Reseña;
import com.methaporce.shop.app.entities.Usuario;
import com.methaporce.shop.app.repositorys.ProductoRepository;
import com.methaporce.shop.app.repositorys.ReseñaRepository;
import com.methaporce.shop.app.repositorys.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@Service
public class ReseñaService  implements ReseñaServiceI {
    @Autowired
    ReseñaRepository reseñaRepository;
    @Autowired
    ProductoRepository productoRepository;
    @Autowired
    UsuarioRepository usuarioRepository;
    @Override

    public Reseña agregarReseña(Long productoId, Long usuarioId, int calificacion, String comentario) {
        Producto producto = productoRepository.findById(productoId)
                .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado"));

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado"));

        Reseña reseña = new Reseña();
        reseña.setProducto(producto);
        reseña.setUsuario(usuario);
        reseña.setCalificacion(calificacion);
        reseña.setComentario(comentario);
        reseña.setFechaReseña(LocalDateTime.now());

        return reseñaRepository.save(reseña);
    }
}
