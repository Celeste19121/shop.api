package com.methaporce.shop.app.service;

import com.methaporce.shop.app.configuration.JwtProvider;
import com.methaporce.shop.app.entities.AuthRequest;
import com.methaporce.shop.app.entities.AuthResponse;
import com.methaporce.shop.app.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AuthService  {
    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    public AuthResponse login(AuthRequest authRequest) {
        try {
            authenticateSecurity(authRequest.getEmail(), authRequest.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid credentials");
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getEmail());
        String token = jwtProvider.generateToken(userDetails);
        return new AuthResponse(token);
    }

    public AuthResponse registro(Usuario usuario) {
        // Implementa la lógica para registrar al usuario
        // y luego retorna el token generado
        // ...
        // Por ejemplo, podrías crear el usuario en la base de datos y luego autenticarlo
        return login(new AuthRequest(usuario.getEmail(), usuario.getPassword()));
    }

    private void authenticateSecurity(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );
        } catch (DisabledException e) {
            e.printStackTrace();
            throw new Exception("User disabled: " + e.getMessage());
        } catch (BadCredentialsException e) {
            e.printStackTrace();
            throw new Exception("Invalid credentials: " + e.getMessage());
        }
    }

}