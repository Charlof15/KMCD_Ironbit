package com.ironbit.app.utillities.err;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandle {
	
	@ExceptionHandler(ExceptionCustom.class)
    public ResponseEntity<?> manejarMiExcepcion(ExceptionCustom ex) {
        GeneralOutputError outputErr = new GeneralOutputError(ex.getMessage(),HttpStatus.BAD_REQUEST.toString());
        return new ResponseEntity<>(outputErr, HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<?> manejarMiExcepcion(Exception ex) {
        GeneralOutputError outputErr = new GeneralOutputError(ex.getMessage(),HttpStatus.BAD_REQUEST.toString());
        return new ResponseEntity<>(outputErr, HttpStatus.BAD_REQUEST);
    }
	
}
