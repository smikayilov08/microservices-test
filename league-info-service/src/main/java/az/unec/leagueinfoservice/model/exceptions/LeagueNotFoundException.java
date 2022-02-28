package az.unec.leagueinfoservice.model.exceptions;

import java.util.NoSuchElementException;

public class LeagueNotFoundException extends NoSuchElementException {
    public LeagueNotFoundException() {
        super();
    }

    public LeagueNotFoundException(String message) {
        super(message);
    }
}
