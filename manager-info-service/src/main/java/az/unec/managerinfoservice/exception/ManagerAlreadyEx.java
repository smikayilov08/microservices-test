package az.unec.managerinfoservice.exception;


public class ManagerAlreadyEx extends RuntimeException {
    public ManagerAlreadyEx() {
        super();
    }

    public ManagerAlreadyEx(String message) {
        super(message);
    }
}
