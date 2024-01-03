package Repositories;

import Models.Ticket;

import java.util.HashMap;

public class TicketRepository {
    private HashMap<Long,Ticket> ticketTableMock= new HashMap<>();
    private Long autoIncrementIDMock=0L;
    public Ticket save(Ticket ticket) {
        if (ticket.getId() == null) {
            autoIncrementIDMock++;
            ticket.setId(autoIncrementIDMock);
            ticketTableMock.put(autoIncrementIDMock, ticket);
        } else {
            ticketTableMock.put(ticket.getId(), ticket);
        }
        return ticket;

    }
}
