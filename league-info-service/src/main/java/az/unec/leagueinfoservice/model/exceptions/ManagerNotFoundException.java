package az.unec.leagueinfoservice.model.exceptions;

public class ManagerNotFoundException extends NoSuchFieldError{
    public ManagerNotFoundException() {
        super();
    }

    public ManagerNotFoundException(String s) {
        super(s);
    }
}
