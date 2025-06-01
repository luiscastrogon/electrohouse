package com.electrohouse.aplicacion.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "documentos")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_documento;

    @Column(nullable = false, length = 100, unique = false)
    private String tipo_documento;

}
