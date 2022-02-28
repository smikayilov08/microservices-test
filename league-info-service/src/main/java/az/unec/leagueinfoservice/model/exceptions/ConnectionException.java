package az.unec.leagueinfoservice.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

public class ConnectionException extends HttpClientErrorException {


    public ConnectionException(HttpStatus statusCode) {
        super(statusCode);
    }
}
