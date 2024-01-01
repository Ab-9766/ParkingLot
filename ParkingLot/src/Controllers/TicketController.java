package Controllers;

import DTOs.GenerateTicketRequestDTO;
import DTOs.GenerateTicketResponseDTO;
import DTOs.ResponseStatus;
import Models.Ticket;
import Services.Strategies.TicketService;

public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    GenerateTicketResponseDTO generateTicket(GenerateTicketRequestDTO requestDTO){
        GenerateTicketResponseDTO responseDTO= null;

        try {
           Ticket ticket= ticketService.generateTicket(requestDTO);
           responseDTO.setGenerateTicketID(ticket.getId());
           responseDTO.setStatus(ResponseStatus.SUCCESS);
            responseDTO.setMessage("Ticket Generated Successfully");

        }catch (Exception ex){
            responseDTO.setStatus(ResponseStatus.FAILURE);
            responseDTO.setMessage(ex.getMessage());
            //Ideally we don't provide exception messages as they are prone to outside world
            //Log it and give client the logID to report
        }
        return responseDTO;
    }
}
