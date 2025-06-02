package com.electrohouse.aplicacion.controller;

import com.electrohouse.aplicacion.model.Usuario;
import com.electrohouse.aplicacion.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/api/v1/usuario")
    public ResponseEntity<?> getUsuarios() {
        List<Usuario> usuarios = usuarioService.findAll();
        return ResponseEntity.status(200).body(usuarios);

    }

    //Busqueda personalizada por usuario (correo).

    @GetMapping("/api/v1/usuario/{correo}")
    public ResponseEntity<?> getUsuarioByCorreo(@PathVariable String correo) {
        Usuario usuario = usuarioService.findBycorreo(correo);
        return ResponseEntity.status(200).body(usuario);
    }

    //Registro nuevo usuario

    @PostMapping("/api/v1/usuario")
    public ResponseEntity<?> nuevoUsuario(@RequestBody Usuario usuario) {
        Usuario nuevoUsuario = usuarioService.save(usuario);

        return ResponseEntity.status(201).body(nuevoUsuario);
    }
}
