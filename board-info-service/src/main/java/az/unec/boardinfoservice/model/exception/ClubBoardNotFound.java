package az.unec.boardinfoservice.model.exception;

import java.util.NoSuchElementException;

public class ClubBoardNotFound extends NoSuchElementException {
    public ClubBoardNotFound() {
        super();
    }

    public ClubBoardNotFound(String s) {
        super(s);
    }
}
