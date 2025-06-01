package com.electrohouse.aplicacion.controller;

import com.electrohouse.aplicacion.model.Producto;
import com.electrohouse.aplicacion.service.ProductoService;
import com.electrohouse.aplicacion.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController

public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/api/v1/producto")
    public ResponseEntity<?> getProducto() {
        List<Producto> productos = productoService.findAll();
        return ResponseEntity.status(200).body(productos);
    }
}
