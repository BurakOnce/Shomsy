package com.example.shomsy.controllers.advice;

import com.example.shomsy.dtos.response.ErrorDetails;
import com.example.shomsy.exceptions.AuthenticationException;
import com.example.shomsy.exceptions.UserAlreadyExistException;
import com.example.shomsy.exceptions.UserNotFoundException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@ControllerAdvice
@RequiredArgsConstructor
@Getter
@Setter
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    private final ErrorDetails errorDetails;

    @ResponseBody
    @ExceptionHandler(DataIntegrityViolationException.class)
    public final ResponseEntity<ErrorDetails> handleUniqueConstraintViolationException(Exception exception, WebRequest request){
        errorDetails.setErrorDetailsProperties(LocalDateTime.now(),
                "Element or Elements are already exist",
                request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.CONFLICT);
    }

    @ResponseBody
    @ExceptionHandler(UserAlreadyExistException.class)
    public final ResponseEntity<ErrorDetails> handleUniqueConstraintViolationException2(Exception exception, WebRequest request){
        errorDetails.setErrorDetailsProperties(LocalDateTime.now(),
                "Element or Elements are already exist",
                request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.CONFLICT);
    }

    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<ErrorDetails> handleUniqueConstraintViolationException4(Exception exception, WebRequest request){
        errorDetails.setErrorDetailsProperties(LocalDateTime.now(),
                "User Not Found",
                request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.CONFLICT);
    }

    @ResponseBody
    @ExceptionHandler(NoSuchElementException.class)
    public final ResponseEntity<ErrorDetails> handleUniqueConstraintViolationException3(Exception exception, WebRequest request){
        errorDetails.setErrorDetailsProperties(LocalDateTime.now(),
                "Element not found",
                request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.CONFLICT);
    }

    @ResponseBody
    @ExceptionHandler(AuthenticationException.class)
    public final ResponseEntity<ErrorDetails> handleUniqueConstraintViolationException5(Exception exception, WebRequest request){
        errorDetails.setErrorDetailsProperties(LocalDateTime.now(),
                exception.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.CONFLICT);
    }
}
