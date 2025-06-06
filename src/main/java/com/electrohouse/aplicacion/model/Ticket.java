package com.electrohouse.aplicacion.model;
import com.electrohouse.aplicacion.model.Usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tickets")
@Data
@NoArgsConstructor
@AllArgsConstructor


public class Ticket {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTicket;

    @Column(nullable = false, length = 100, unique = false)
    private String categorias;

    @Column(nullable = false, length = 100, unique = false)
    private String estados;

    @Column(nullable = false, length = 100)
    private String correoSolicitante;

}



