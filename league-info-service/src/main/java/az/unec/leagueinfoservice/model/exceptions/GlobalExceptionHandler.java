package az.unec.leagueinfoservice.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ErrorResponse handleLeagueNotFoundException(LeagueNotFoundException ex) {
        return new ErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND, LocalDateTime.now());
    }
}
