package com.electrohouse.aplicacion.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_usuario;

    @Column(nullable = false, length = 100, unique = false)
    private String nombres;

    @Column(nullable = false, length = 100, unique = false)
    private String apellidos;

    @Column(nullable = false, length = 100, unique = false)
    private String rut;

    @Column(nullable = false, length = 100, unique = false)
    private String direccion;

    @Column(nullable = false, length = 100, unique = false)
    private int telefono ;

    @Column(nullable = false, length = 100, unique = false)
    private String correo;

    @Column(nullable = false, length = 100, unique = false)
    private String tipo;

}
