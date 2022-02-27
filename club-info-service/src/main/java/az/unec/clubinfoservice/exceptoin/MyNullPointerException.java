package az.unec.clubinfoservice.exceptoin;

public class MyNullPointerException extends NullPointerException{
    public MyNullPointerException() {
        super();
    }

    public MyNullPointerException(String s) {
        super(s);
    }
}
