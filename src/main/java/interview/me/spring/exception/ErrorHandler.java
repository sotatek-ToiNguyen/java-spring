package interview.me.spring.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleTeacherNotFoundError(NotFoundException ex) {
        return new ResponseEntity<>(
                new ErrorResponse(ex.getCode(), ex.getMessage()), HttpStatus.NOT_FOUND);
    }
}
