package Repositories;

import Models.Ticket;
import Models.Vehicle;

import java.util.HashMap;
import java.util.Optional;

public class VehicleRepository {
    private HashMap<Long,Vehicle> vehicleTableMock= new HashMap<>();
    private Long autoIncrementIDMock=0L;

    public Vehicle save(Vehicle vehicle) {
            if (vehicle.getId() == null) {
                autoIncrementIDMock++;
                vehicle.setId(autoIncrementIDMock);
                vehicleTableMock.put(autoIncrementIDMock, vehicle);
            } else {
                vehicleTableMock.put(vehicle.getId(), vehicle);
            }
            return vehicle;
        }
    public Optional<Vehicle> fetchVehicleByNumber(String vehicleNumber) {
        for(Vehicle vehicle:vehicleTableMock.values())
        {
            if(vehicle.getVehicleNumber().equals(vehicleNumber)){
                return Optional.of(vehicle);
            }
        }
        return Optional.empty();
    }
    public Optional<Vehicle> fetchVehicleByID( Long vehicleID){
        if(vehicleTableMock.containsKey(vehicleID)){
            return Optional.of(vehicleTableMock.get(vehicleID));
        }
        else{
            return Optional.empty();
        }
    }
}
