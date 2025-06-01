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
    private Integer id_producto;

    @Column(nullable = false, length = 100, unique = false)
    private String nombre_producto;

    @Column(nullable = false, length = 100, unique = false)
    private String estado_producto;

}
