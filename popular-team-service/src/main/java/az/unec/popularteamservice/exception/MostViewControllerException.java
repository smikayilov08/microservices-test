package az.unec.popularteamservice.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class MostViewControllerException {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> mostViewException() {

        Map<String, Object> obj = new HashMap<>();
        obj.put("message", "Teams not found");
        obj.put("date", LocalDateTime.now());

        return ResponseEntity.ok(obj);
    }
}
