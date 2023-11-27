package edu.hillel.springmvclesson29.exceptions;

import edu.hillel.springmvclesson29.response.ResponseBodyInterface;
import edu.hillel.springmvclesson29.response.body.WarnBody;
import edu.hillel.springmvclesson29.response.enums.WarnCode;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<ResponseBodyInterface> orderNotFound(@NotNull OrderNotFoundException e) {
        return new ResponseEntity<>(new WarnBody(WarnCode.ORDER_NOT_FOUND_EXCEPTION_WARN, e.getMessage()), HttpStatus.NOT_FOUND);
    }
}
