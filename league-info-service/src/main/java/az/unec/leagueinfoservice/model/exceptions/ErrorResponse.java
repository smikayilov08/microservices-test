package az.unec.leagueinfoservice.model.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {
    private final String message;
    private final HttpStatus status;
    private final LocalDateTime dateTime;
}
