package Models;

import java.util.List;

public class ParkingLot extends BaseModel{
    private String name;
    private String address;

    List<ParkingBooth> Booths;
    List<Gate> gates;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<ParkingBooth> getBooths() {
        return Booths;
    }

    public void setBooths(List<ParkingBooth> booths) {
        Booths = booths;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }
}
