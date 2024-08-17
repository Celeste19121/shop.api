package com.methaporce.shop.app.controllers;

import com.methaporce.shop.app.entities.AuthRequest;
import com.methaporce.shop.app.entities.AuthResponse;
import com.methaporce.shop.app.entities.Usuario;
import com.methaporce.shop.app.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest authRequest) {
        try {
            AuthResponse auth = authService.login(authRequest);
            return ResponseEntity.ok(auth);
        } catch (Exception e) {
            return ResponseEntity.status(401).body(null);
        }
    }

    @PostMapping("/registro")
    public ResponseEntity<AuthResponse> registro(@RequestBody Usuario usuario) {
        try {
            AuthResponse auth = authService.registro(usuario);
            return ResponseEntity.ok(auth);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(null);
        }
    }

}
