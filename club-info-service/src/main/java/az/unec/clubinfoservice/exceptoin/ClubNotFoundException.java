package az.unec.clubinfoservice.exceptoin;

import java.util.NoSuchElementException;

public class ClubNotFoundException extends NoSuchElementException {
    public ClubNotFoundException() {
        super();
    }

    public ClubNotFoundException(String s) {
        super(s);
    }
}
