package com.electrohouse.aplicacion.controller;

import com.electrohouse.aplicacion.model.Usuario;
import com.electrohouse.aplicacion.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController

public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    //llamada datos de usuario

    @GetMapping("/api/v1/usuario")
    public ResponseEntity<?> getUsuarios() {
        List<Usuario> usuarios = usuarioService.findAll();
        return ResponseEntity.status(200).body(usuarios);

    }

    //Buscar usuario por usuario login (correo).

    @GetMapping("/api/v1/usuario/traerusuario/{correo}")
    public ResponseEntity<?> getUsuarioByCorreo(@PathVariable String correo) {
        Usuario usuario = usuarioService.findBycorreo(correo);

        if (usuario == null) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(200).body(usuario);
    }

    //llamada personalizada a la clave.

    @GetMapping("/api/v1/traerclave/{clave}")
    public ResponseEntity<?> getUsuarioByClave(@PathVariable String clave) {
        Usuario usuario = usuarioService.findByclave(clave);

        if (usuario == null) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(200).body(usuario);
    }

    //Registro nuevo usuario

    @PostMapping("/api/v1/usuario/nuevo")
    public ResponseEntity<?> nuevoUsuario(@RequestBody Usuario usuario) {
        Usuario nuevoUsuario = usuarioService.save(usuario);

        return ResponseEntity.status(201).body(nuevoUsuario);
    }

    //login de usuario.

    @PostMapping("/api/v1/usuario/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> request) {
        String correo = request.get("correo");
        String clave = request.get("clave");

        Optional<Usuario> usuario = usuarioService.login(correo, clave);

        if (usuario.isPresent()) {
            return ResponseEntity.status(200).body(usuario.get());
        }
        return ResponseEntity.status(404).build();
    }

    //para cambiar contraseña.

    @PutMapping("/api/v1/usuario/login/cambioclave")
    public ResponseEntity<?> changePassword(@RequestBody Map<String, String> request) {
        String correo = request.get("correo");
        String nuevaClave = request.get("nuevaClave");
        boolean nuevoBoolean = usuarioService.changePassword(correo, nuevaClave);

        if (nuevoBoolean) {
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }


}
