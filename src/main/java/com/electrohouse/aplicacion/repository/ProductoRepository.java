package com.electrohouse.aplicacion.repository;

import com.electrohouse.aplicacion.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    Optional<Producto> findByNombreProducto(String nombreProducto);



}
