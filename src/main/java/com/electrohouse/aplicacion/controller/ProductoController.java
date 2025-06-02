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
    //Llamar una lista con todos los productos
    @GetMapping("/api/v1/producto")
    public ResponseEntity<?> getProducto() {
        List<Producto> productos = productoService.findAll();
        return ResponseEntity.status(200).body(productos);
    }
    //Buscar Producto por el ID
    @GetMapping("/api/v1/producto/{id}")
    public ResponseEntity<?> getProductoPorId(@PathVariable Integer id) {
        Producto producto = productoService.findById(id);
        if (producto == null) {
            return ResponseEntity.status(404).body("Producto no encontrado");
        }
        return ResponseEntity.ok(producto);
    }
    //Validar disponibilidad de un producto segun Stock
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
    //Crear Un nuevo Producto
    @PostMapping("/api/v1/producto/nuevoProducto")
    public ResponseEntity<?> crearProducto(@RequestBody Producto producto) {
        Producto nuevoProducto = productoService.save(producto);
        return ResponseEntity.status(201).body(nuevoProducto);
    }
    //Editar el nombre de un producto
    @PatchMapping("/api/v1/producto/editarNombre/{id}/nombre")
    public ResponseEntity<?> actualizarNombreProducto(@PathVariable Integer id, @RequestBody Map<String, String> datos) {
        String nuevoNombre = datos.get("nombreProducto");

        Producto producto = productoService.findById(id);
        if (producto == null) {
            return ResponseEntity.status(404).body("Producto no encontrado");
        }

        producto.setNombreProducto(nuevoNombre);
        productoService.save(producto);
        return ResponseEntity.ok(producto);
    }
    //Editar estado de un Producto
    @PatchMapping("/api/v1/producto/editarEstado/{id}/estado")
    public ResponseEntity<?> actualizarEstadoProducto(@PathVariable Integer id, @RequestBody Map<String, String> datos) {
        String nuevoEstado = datos.get("estadoProducto");

        Producto producto = productoService.findById(id);
        if (producto == null) {
            return ResponseEntity.status(404).body("Producto no encontrado");
        }

        producto.setEstadoProducto(nuevoEstado);
        productoService.save(producto);
        return ResponseEntity.ok(producto);
    }
    //Editar el stock de un producto
    @PatchMapping("/api/v1/producto/editarStock/{id}/stock")
    public ResponseEntity<?> actualizarStockProducto(@PathVariable Integer id, @RequestBody Map<String, Integer> datos) {
        Integer nuevoStock = datos.get("stockProducto");

        if (nuevoStock == null || nuevoStock < 0) {
            return ResponseEntity.badRequest().body("El stock debe ser un número mayor o igual a 0");
        }

        Producto producto = productoService.findById(id);
        if (producto == null) {
            return ResponseEntity.status(404).body("Producto no encontrado");
        }

        producto.setStockProducto(nuevoStock);
        productoService.save(producto);
        return ResponseEntity.ok(producto);
    }
    //Para eliminar un Producto con el ID
    @DeleteMapping("/api/v1/producto/eliminar/{id}")
    public ResponseEntity<?> eliminarProducto(@PathVariable Integer id) {
        Producto producto = productoService.findById(id);
        if (producto == null) {
            return ResponseEntity.status(404).body("Producto no encontrado");
        }

        productoService.delete(id);
        return ResponseEntity.ok("Producto eliminado correctamente");
    }

}
