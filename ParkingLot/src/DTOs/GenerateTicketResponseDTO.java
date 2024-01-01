package DTOs;

public class GenerateTicketResponseDTO {
    private Long generateTicketID; //Instead of whole model we can pass on the least info
    //required as it will get all required details through id
    private String message;
    private ResponseStatus status;

    public Long getGenerateTicketID() {
        return generateTicketID;
    }

    public void setGenerateTicketID(Long generateTicketID) {
        this.generateTicketID = generateTicketID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }
}
