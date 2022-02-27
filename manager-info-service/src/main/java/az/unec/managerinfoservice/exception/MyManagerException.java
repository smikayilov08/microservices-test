package az.unec.managerinfoservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class MyManagerException {
    HttpStatus status = HttpStatus.BAD_REQUEST;

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Object> notReadableMessage(HttpMessageNotReadableException e) {
        ApiException exception = new ApiException(
                e.getMessage(),
                status,
                LocalDateTime.now()
        );
        return new ResponseEntity<>(exception, status);
    }

    @ExceptionHandler(ManagerAlreadyEx.class)
    public ResponseEntity<Object> userAlreadyex(ManagerAlreadyEx e) {
        ApiException exception = new ApiException(
                e.getMessage(),
                status,
                LocalDateTime.now()
        );
        return new ResponseEntity<>(exception, status);
    }

    @ExceptionHandler(MyNullPointerException.class)
    public ResponseEntity<Object> nullPointerEx(MyNullPointerException e) {
        ApiException exception = new ApiException(
                e.getMessage(),
                status,
                LocalDateTime.now()
        );
        return new ResponseEntity<>(exception, status);
    }

    @ExceptionHandler(ManagerNotFoundException.class)
    public ResponseEntity<Object> userNotFound(ManagerNotFoundException e){
        ApiException exception = new ApiException(
                e.getMessage(),
                status,
                LocalDateTime.now()
        );
        return new ResponseEntity<>(exception, status);
    }
}
