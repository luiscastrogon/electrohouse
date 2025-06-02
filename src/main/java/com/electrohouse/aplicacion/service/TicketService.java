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

            //enviarCorreo(ticket);
            return true;
        }
        return false;
    }

    //Método privado para enviar correo cuando se cambia el estado

    /*private void enviarCorreo(Ticket ticket) {
        Usuario usuario = ticket.getUsuario();
        String to = usuario.getCorreo();
        String setSubject = "Actualización de estado de tu ticket";
        String Text = "Hola,\n\nTu ticket con ID #" + ticket.getIdTicket() +
                " ha sido actualizado al estado: " + ticket.getEstados() + "." +
                "\n\nSaludos,\nSoporte Técnico";

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(setSubject);
        message.setText(Text);
        mailSender.send(message);

    } */
}
