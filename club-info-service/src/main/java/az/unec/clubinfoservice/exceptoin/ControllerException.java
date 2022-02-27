package az.unec.clubinfoservice.exceptoin;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

import java.net.ConnectException;
import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerException {
    HttpStatus status=HttpStatus.BAD_REQUEST;

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Object> messageNotReadable(HttpMessageNotReadableException e){
        ApiException exception=new ApiException(
                e.getMessage(),
                status,
                LocalDateTime.now()
        );
        return new ResponseEntity<>(exception,status);
    }
    @ExceptionHandler(ClubNotFoundException.class)
    public ResponseEntity<Object> clubNotFound(ClubNotFoundException e){
        ApiException exception=new ApiException(
                e.getMessage(),
                status,
                LocalDateTime.now()
        );
        return new ResponseEntity<>(exception,status);
    }

    @ExceptionHandler(MyNullPointerException.class)
    public ResponseEntity<Object>nullPointer(MyNullPointerException e){
        ApiException exception=new ApiException(
                e.getMessage(),
                status,
                LocalDateTime.now()
        );
        return new ResponseEntity<>(exception,status);
    }
    @ExceptionHandler(ConnectException.class)
    public ResponseEntity<Object> handleConeectException(ConnectException e) {
        ApiException exception=new ApiException(
                e.getMessage(),
                status,
                LocalDateTime.now()
        );
        return new ResponseEntity<>(exception,status);
    }
    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<Object> handleXXException(HttpClientErrorException e) {
        ApiException exception=new ApiException(
                "Manager doesn't exist",
                status,
                LocalDateTime.now()
        );
        return new ResponseEntity<>(exception,status);
    }
}
