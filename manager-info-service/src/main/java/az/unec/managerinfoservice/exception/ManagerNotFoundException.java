package az.unec.managerinfoservice.exception;

public class ManagerNotFoundException extends NoSuchFieldError{
    public ManagerNotFoundException() {
        super();
    }

    public ManagerNotFoundException(String s) {
        super(s);
    }
}
