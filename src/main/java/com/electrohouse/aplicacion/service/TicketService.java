package com.electrohouse.aplicacion.service;
import com.electrohouse.aplicacion.repository.UsuarioRepository;

import com.electrohouse.aplicacion.model.Ticket;
import com.electrohouse.aplicacion.model.Usuario;
import com.electrohouse.aplicacion.repository.TicketRepository;
import jakarta.mail.MessagingException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JavaMailSender mailSender;

    // Regla para obtener todos los tickets
    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }

    // Regla para guardar un nuevo ticket
    public Ticket save(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    // Regla para buscar ticket por su ID
    public Optional<Ticket> findById(Integer idTicket) {
        return ticketRepository.findById(idTicket);
    }

    // Regla para actualizar el estado del ticket

    public boolean cambiarEstadoTicket(Integer idTicket, String nuevoEstado) {
        Optional<Ticket> optionalTicket = ticketRepository.findById(idTicket);
        if (optionalTicket.isPresent()) {
            Ticket ticket = optionalTicket.get();
            ticket.setEstados(nuevoEstado);
            ticketRepository.save(ticket);


            // Simulación del envío de correo, mas adelante implementaremos

            String correo = ticket.getCorreoSolicitante();
            System.out.println("Para: " + correo);
            System.out.println("Asunto: Estado de ticket actualizado");
            System.out.println("Cuerpo: Hola, el estado de tu ticket #" + ticket.getIdTicket()
                    + " ha sido actualizado a: " + nuevoEstado);

            return true;


        }
        return false;
    }
}