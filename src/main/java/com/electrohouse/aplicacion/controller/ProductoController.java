package com.electrohouse.aplicacion.controller;

import com.electrohouse.aplicacion.model.Producto;
import com.electrohouse.aplicacion.service.ProductoService;
import com.electrohouse.aplicacion.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/api/v1/validarDisponibilidad/{nombre_producto}")
    public ResponseEntity<?> validar_stock(@RequestBody Map<String, Object> datos) {
        String producto = (String) datos.get("producto");
        int cantidad = (int) datos.get("cantidad");

        boolean disponible = productoService.validarDisponibilidad(producto, cantidad);

        if (disponible) {
            return ResponseEntity.ok(Map.of("disponible", true));
        } else {
            return ResponseEntity.status(404).body(Map.of("error", "Stock insuficiente para el producto: " + producto));
        }
    }

}
