package Services.Strategies;

import Models.ENUMS.VehicleType;
import Models.Gate;
import Models.ParkingBooth;

import java.util.Optional;

public interface BoothAllocationStrategy {
    public Optional<ParkingBooth> assignBooth(VehicleType vehicleType, Gate gate);
}
