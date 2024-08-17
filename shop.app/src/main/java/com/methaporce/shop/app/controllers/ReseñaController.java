package com.methaporce.shop.app.controllers;

import com.methaporce.shop.app.entities.Reseña;
import com.methaporce.shop.app.entities.ReseñaRequest;
import com.methaporce.shop.app.service.ReseñaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class ReseñaController {
    @Autowired
    private ReseñaService reseñaService;

    @PostMapping("/agregar")
    public ResponseEntity<Reseña> agregarReseña(@RequestBody ReseñaRequest reseñaRequest) {
        Reseña nuevaReseña = reseñaService.agregarReseña(
                reseñaRequest.getId_producto(),
                reseñaRequest.getId_producto(),
                reseñaRequest.getCalificacion(),
                reseñaRequest.getComentario()
        );
        return ResponseEntity.ok(nuevaReseña);
    }
}
