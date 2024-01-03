package Exceptions;

public class GateNotFoundException extends Exception{
    public GateNotFoundException(){
        super("Gate with gateId not found");
    }
}
