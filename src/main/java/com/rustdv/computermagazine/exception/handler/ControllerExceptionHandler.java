package com.rustdv.computermagazine.exception.handler;

import com.rustdv.computermagazine.exception.NoSuchElementException;
import com.rustdv.computermagazine.exception.NoSuchEnumElementException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler
            (
                    {

                            NoSuchEnumElementException.class,
                            NoSuchElementException.class
                    }
            )
    public ResponseEntity<String> handleException(RuntimeException e) {

        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(e.getMessage());

    }


}
