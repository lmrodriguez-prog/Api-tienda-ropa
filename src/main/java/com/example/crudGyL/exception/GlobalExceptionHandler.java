package com.example.crudGyL.exception;

import com.example.crudGyL.dto.ApiErrorDto;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice 
public class GlobalExceptionHandler {

   
    @ExceptionHandler(RecursosNoEncontradoException.class)
    public ResponseEntity<ApiErrorDto> manejarRecursoNoEncontrado(RecursosNoEncontradoException ex) {
        ApiErrorDto error = new ApiErrorDto(
                ex.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // 400
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiErrorDto> manejarBadRequest(BadRequestException ex) {
        ApiErrorDto error = new ApiErrorDto(
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(org.springframework.web.bind.MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorDto> manejarValidaciones(org.springframework.web.bind.MethodArgumentNotValidException ex) {
        ApiErrorDto error = new ApiErrorDto(
                "Error de validación: " + ex.getBindingResult().getFieldError().getDefaultMessage(),
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorDto> manejarErroresGenerales(Exception ex) {
        ApiErrorDto error = new ApiErrorDto (
                "Ocurrió un error interno: " + ex.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}