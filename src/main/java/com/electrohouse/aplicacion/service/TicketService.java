package com.electrohouse.aplicacion.service;

import com.electrohouse.aplicacion.model.Ticket;
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
    public Optional<Ticket> findById(Integer id) {
        return ticketRepository.findById(id);
    }

    // Regla para actualizar el estado del ticket
    public Ticket updateEstado(Integer id, String nuevoEstado) {
        Optional<Ticket> optionalTicket = ticketRepository.findById(id);
        if (optionalTicket.isEmpty()) {
            throw new EntityNotFoundException("Ticket no encontrado con ID: " + id);
        }

        Ticket ticket = optionalTicket.get();
        ticket.setEstados(nuevoEstado);

        // Guardar cambios en la base de datos
        Ticket actualizado = ticketRepository.save(ticket);

        // Enviar correo al solicitante
        enviarCorreoEstadoActualizado(actualizado);

        return actualizado;
    }

    //Método privado para enviar correo cuando se cambia el estado
    private void enviarCorreoEstadoActualizado(Ticket ticket) {
        SimpleMailMessage mensaje = new SimpleMailMessage();
        mensaje.setTo(ticket.getCorreoSolicitante());
        mensaje.setSubject("Actualización de estado de tu ticket");
        mensaje.setText("Hola,\n\nTu ticket con ID #" + ticket.getIdTicket() +
                " ha sido actualizado al estado: " + ticket.getEstados() + "." +
                "\n\nSaludos,\nSoporte Técnico");
        mailSender.send(mensaje);
    }
}


