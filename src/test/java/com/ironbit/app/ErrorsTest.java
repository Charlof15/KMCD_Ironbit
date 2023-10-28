package com.ironbit.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ironbit.app.utillities.err.ExceptionCustom;
import com.ironbit.app.utillities.err.ExceptionHandle;
import com.ironbit.app.utillities.err.GeneralOutputError;

class ErrorsTest {
	
	GeneralOutputError generalOutput = new GeneralOutputError();
	@Test
    public void testExceptionCustom() {
        String expectedMessage = "Este es un mensaje de prueba";
        ExceptionCustom exception = assertThrows(ExceptionCustom.class, () -> {
            throw new ExceptionCustom(expectedMessage);
        });
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }
	
	@Test
    public void testManejarMiExcepcionCustom() {
        ExceptionCustom exception = new ExceptionCustom("Mensaje de excepcien personalizada");
        ExceptionHandle exceptionHandle = new ExceptionHandle();
        ResponseEntity<?> responseEntity = exceptionHandle.manejarMiExcepcion(exception);
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        GeneralOutputError outputError = (GeneralOutputError) responseEntity.getBody();
        assertNotNull(outputError);
    }

    @Test
    public void testManejarOtraExcepcion() {
        Exception exception = new Exception("Mensaje de excepción generica");
        ExceptionHandle exceptionHandle = new ExceptionHandle();
        ResponseEntity<?> responseEntity = exceptionHandle.manejarMiExcepcion(exception);
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        GeneralOutputError outputError = (GeneralOutputError) responseEntity.getBody();
        assertNotNull(outputError);
    }
    
    @Test
	public void testGetSetMensaje() {
    	generalOutput.setMensaje("Ejemplo Mensaje error");
		assertEquals("Ejemplo Mensaje error",generalOutput.getMensaje());
	}
	
	@Test
    public void testGetSetCode() {
		generalOutput.setCode("OK - 200");
        assertEquals("OK - 200", generalOutput.getCode());
    }
	
	
}
