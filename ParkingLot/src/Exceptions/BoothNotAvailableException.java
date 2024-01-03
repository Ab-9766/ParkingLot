package Exceptions;

public class BoothNotAvailableException extends Exception {
    public BoothNotAvailableException() {
        super("No parkingbooth available");
    }
}
