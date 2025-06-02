package com.electrohouse.aplicacion.controller;

import com.electrohouse.aplicacion.model.Producto;
import com.electrohouse.aplicacion.service.ProductoService;
import com.electrohouse.aplicacion.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController

public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/api/v1/producto")
    public ResponseEntity<?> getProducto() {
        List<Producto> productos = productoService.findAll();
        return ResponseEntity.status(200).body(productos);
    }

    @GetMapping("/api/v1/validarDisponibilidad/{nombreProducto}/{cantidad}")
    public ResponseEntity<?> validarStock(@PathVariable String nombreProducto,
                                          @PathVariable int cantidad) {
        boolean disponible = productoService.validarDisponibilidad(nombreProducto, cantidad);
        if (disponible) {
            return ResponseEntity.ok(Map.of("disponible", true));
        } else {
            return ResponseEntity.status(404).body(Map.of("error", "Stock insuficiente para el producto: " + nombreProducto));
        }
    }

}
