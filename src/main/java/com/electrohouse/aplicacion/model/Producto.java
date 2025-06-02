package com.electrohouse.aplicacion.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "productos")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProducto;

    @Column(nullable = false, length = 100, unique = false)
    private String nombreProducto;

    @Column(nullable = false, length = 100, unique = false)
    private String estadoProducto;

    @Column(nullable = false, length = 100, unique = false)
    private Integer stockProducto;

}
