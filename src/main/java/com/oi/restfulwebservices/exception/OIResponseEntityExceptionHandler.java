package com.oi.restfulwebservices.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestControllerAdvice
@RestController
public class OIResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(Exception.class)
  public final ResponseEntity<Object> handleAllExceptions(Exception ex,
                                                          WebRequest request) throws Exception {
    GenericException genericException =
            new GenericException(new Date(), ex.getMessage(), request.getDescription(false));

    return new ResponseEntity<>(genericException, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(UserNotFoundException.class)
  public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex,
                                                                  WebRequest request) throws Exception {
    GenericException genericException =
            new GenericException(new Date(), ex.getMessage(), request.getDescription(false));

    return new ResponseEntity<>(genericException, HttpStatus.NOT_FOUND);
  }

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                HttpHeaders headers,
                                                                HttpStatus status,
                                                                WebRequest request) {

    GenericException genericException =
            new GenericException(new Date(), "Validation Failure", ex.getBindingResult().toString());
    return new ResponseEntity<>(genericException, HttpStatus.BAD_REQUEST);
  }
}
