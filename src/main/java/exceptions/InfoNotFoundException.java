package exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Info not found")
public class InfoNotFoundException extends RuntimeException{

    @Getter
    long id;

    public InfoNotFoundException(long id){
        this.id = id;
    }

}