package com.electrohouse.aplicacion.controller;

import com.electrohouse.aplicacion.model.Ticket;
import com.electrohouse.aplicacion.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class TicketController {


    @Autowired
    private TicketService ticketService;

    @GetMapping("/api/v1/ticket")
    public ResponseEntity<?> getTickets() {
        List<Ticket> tickets = ticketService.findAll();
        return ResponseEntity.status(200).body(tickets);
    }
}
