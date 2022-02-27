package az.unec.clubinfoservice.exceptoin;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@AllArgsConstructor
@Setter
@Getter
public class ApiException {
    private final String message;
    private final HttpStatus status;
    private final LocalDateTime dateTime;

}
