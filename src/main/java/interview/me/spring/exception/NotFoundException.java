package interview.me.spring.exception;


import lombok.Value;

@Value
public class NotFoundException extends RuntimeException {
    final String code;
    final String message;
}
