import Controllers.TicketController;
import DTOs.GenerateTicketRequestDTO;
import DTOs.GenerateTicketResponseDTO;
import DTOs.ResponseStatus;
import Models.ENUMS.VehicleType;
import Repositories.*;
import Services.GateService;
import Services.Strategies.BoothAllocationStrategy;
import Services.Strategies.NearestEmptyBoothStrategy;
import Services.TicketService;
import Services.VehicleService;

public class Client {
    public static void main(String[] args) {
        TicketRepository ticketRepository=new TicketRepository();
        GateRepository gateRepository= new GateRepository();
        GateService gateService= new GateService(gateRepository);

        VehicleRepository vehicleRepository=new VehicleRepository();
        VehicleService vehicleService=new VehicleService(vehicleRepository);

        ParkingLotRepository parkingLotRepository= new ParkingLotRepository();
        ParkingBoothRepository parkingBoothRepository= new ParkingBoothRepository();

        BoothAllocationStrategy boothAllocationStrategy=
                new NearestEmptyBoothStrategy(parkingLotRepository,parkingBoothRepository);




        TicketService ticketService= new TicketService(ticketRepository,gateService,vehicleService,boothAllocationStrategy);
        //TicketController is dependent on ticketservice object
        //Generate a ticket on entry gate
        TicketController ticketController= new TicketController(ticketService);

        GenerateTicketRequestDTO ticketRequestDTO= new GenerateTicketRequestDTO();
        ticketRequestDTO.setVehicleNumber("UP 16 CX 0977");
        ticketRequestDTO.setVehicleType(VehicleType.MEDIUM);
        ticketRequestDTO.setGateId(10L);

        GenerateTicketResponseDTO ticketResponseDTO=ticketController.generateTicket(ticketRequestDTO);
        if(ticketResponseDTO.getStatus().equals(ResponseStatus.FAILURE)){
            System.out.println(ticketResponseDTO.getMessage());
        }
        else{
            System.out.println("Ticket Generated ID:" +ticketResponseDTO.getGenerateTicketID());
        }
    }
}