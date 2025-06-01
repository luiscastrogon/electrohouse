package com.electrohouse.aplicacion.controller;

<<<<<<< HEAD
import com.electrohouse.aplicacion.model.Usuario;
import com.electrohouse.aplicacion.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
=======
public class UsuarioController {

    //
>>>>>>> 2b6551acde06170fa22ad0f91c8b22da0c314b0c
}
