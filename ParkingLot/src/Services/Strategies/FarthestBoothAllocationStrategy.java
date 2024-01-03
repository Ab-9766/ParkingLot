package Services.Strategies;

import Models.ENUMS.ParkingBoothStatus;
import Models.ENUMS.VehicleType;
import Models.Gate;
import Models.ParkingBooth;
import Models.ParkingLot;
import Repositories.ParkingBoothRepository;
import Repositories.ParkingLotRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class FarthestBoothAllocationStrategy implements BoothAllocationStrategy{
    private ParkingBoothRepository parkingBoothRepository;
    private ParkingLotRepository parkingLotRepository;
    public Optional<ParkingBooth> assignBooth(VehicleType vehicleType, Gate gate){
        ParkingLot parkingLot= parkingLotRepository.fetchGateById(gate.getId());
        List<ParkingBooth> parkingBoothList=parkingBoothRepository.fetchAllParkingLots(parkingLot.getId());

        Collections.reverse(parkingBoothList);
        for(ParkingBooth parkingBooth:parkingBoothList){
            if(parkingBooth.getBoothStatus().equals(ParkingBoothStatus.AVAILABLE) &&
                    parkingBooth.getSupportedVehicleType().equals(vehicleType)){
                return Optional.of(parkingBooth);
            }
        }
        return Optional.empty();
    }

}
