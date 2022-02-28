package az.unec.leagueinfoservice.model.exceptions;

public class ConnectionException extends RuntimeException {

    public ConnectionException() {
        super();
    }

    public ConnectionException(String message) {
        super(message);
    }
}
