package com.electrohouse.aplicacion.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "despachos")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Despacho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer despachoId;

    @Column(nullable = false, length = 100, unique = false)
    private String tipoDespacho;
}
