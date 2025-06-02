package com.electrohouse.aplicacion.service;

import com.electrohouse.aplicacion.model.Producto;
import com.electrohouse.aplicacion.repository.ProductoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional

public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> findAll() {
        return  productoRepository.findAll();
    }

    public boolean validarDisponibilidad(String nombre_producto, int cantidadRequerida) {
        return productoRepository.findByNombre_producto(nombre_producto)
                .map(producto -> producto.getStock_producto() >= cantidadRequerida)
                .orElse(false);
    }
}
