package Services;

import Exceptions.BoothNotAvailableException;
import Exceptions.GateNotFoundException;
import Models.ENUMS.VehicleType;
import Models.Gate;
import Models.ParkingBooth;
import Models.Ticket;
import Models.Vehicle;
import Repositories.TicketRepository;
import Services.Strategies.BoothAllocationStrategy;

import java.util.Date;
import java.util.Optional;

public class TicketService {
    private TicketRepository ticketRepository;
    private GateService gateService;
    private VehicleService vehicleService;
    private BoothAllocationStrategy boothAllocationStrategy;

    public TicketService(TicketRepository ticketRepository, GateService gateService,
                         VehicleService vehicleService, BoothAllocationStrategy boothAllocationStrategy) {

        this.ticketRepository = ticketRepository;
        this.gateService = gateService;
        this.vehicleService = vehicleService;
        this.boothAllocationStrategy = boothAllocationStrategy;
    }

    public Ticket generateTicket (Long gateId, String vehicleNumber, VehicleType vehicleType)
            throws GateNotFoundException, BoothNotAvailableException {

        Gate gate= gateService.getGateById(gateId);
        Vehicle vehicle= vehicleService.getVehicle(vehicleNumber,vehicleType);

        Optional<ParkingBooth> assignedBoothWrapper= boothAllocationStrategy.assignBooth(vehicleType,gate);
        if(assignedBoothWrapper.isEmpty())
            throw new BoothNotAvailableException();

        Ticket ticket= new Ticket();
        ticket.setEntryGate(gate);
        ticket.setEntryTime(new Date());
        ticket.setVehicle(vehicle);
        ticket.setAssignedBooth(assignedBoothWrapper.get());
        ticket.setOperator(gate.getCurrentOperator());

        Ticket savedTicket=ticketRepository.save(ticket);


        return savedTicket;

    }


}
