package com.methaporce.shop.app.controllers;

import com.methaporce.shop.app.entities.Transaccion;
import com.methaporce.shop.app.service.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pagos")
public class TransaccionController {
    @Autowired
    TransaccionService transaccionService;

    @PostMapping
    public ResponseEntity<Transaccion> crearTransaccion(@RequestBody Transaccion transaccion) {
        return new ResponseEntity<>(transaccionService.crearTransaccion(transaccion), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaccion> obtenerTransaccionPorId(@PathVariable Long id) {
        return transaccionService.obtenerTransaccionById(id)
                .map(transaccion -> new ResponseEntity<>(transaccion, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
