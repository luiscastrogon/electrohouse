package com.electrohouse.aplicacion.controller;

import com.electrohouse.aplicacion.model.Ticket;
import com.electrohouse.aplicacion.service.TicketService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController

public class TicketController {



    @Autowired
    private TicketService ticketService;

    // Obtener todos los tickets
    @GetMapping
    public ResponseEntity<List<Ticket>> getAllTickets() {
        return ResponseEntity.ok(ticketService.findAll());
    }

    // Crear un nuevo ticket
    @PostMapping("/api/v1/ticket/crearticket")
    public ResponseEntity<Ticket> crearTicket(@RequestBody Ticket ticket) {
        try {
            Ticket nuevo = ticketService.save(ticket);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    // Obtener ticket por ID
    @GetMapping("/api/v1/ticket/traerticket")
    public ResponseEntity<?> getTicketById(@PathVariable Integer idTicket) {
        Optional<Ticket> ticket = ticketService.findById(idTicket);
        if (ticket.isPresent()) {
            return ResponseEntity.ok(ticket.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ticket no encontrado");
        }
    }

    // Cambiar estado del ticket y enviar correo
    @PutMapping("/api/v1/ticket/{idTicket}/cambiarestado")
    public ResponseEntity<?> actualizarEstado(@PathVariable Integer idTicket, @RequestBody Map<String, String> request) {
        String nuevoEstado = request.get("estados");
        boolean nuevoboolean = ticketService.cambiarEstadoTicket(idTicket, nuevoEstado);
        if (nuevoboolean) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

    }
}
