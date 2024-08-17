package com.methaporce.shop.app.service;

import com.methaporce.shop.app.entities.Reseña;

public interface ReseñaServiceI {
    Reseña agregarReseña(Long id_producto, Long id, int calificacion, String comentario);
}
