import Controllers.TicketController;
import DTOs.GenerateTicketResponseDTO;
import Services.Strategies.TicketService;

public class Client {
    public static void main(String[] args) {
        TicketService ticketService= new TicketService();
        //TicketController is dependent on ticketserive object
        //Generate a ticket on entry gate
        TicketController ticketController= new TicketController(ticketService);
        ticketController.generateTicket(?,?,?);

    }
}