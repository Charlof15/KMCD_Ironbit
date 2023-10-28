package com.ironbit.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;

import com.ironbit.app.entity.Empleado;

public class EmpleadoTest {
	
	private Empleado empleado = new Empleado();
	
	@Test
	public void testGetSetId() {
		empleado.setId(15l);
		assertEquals(15l,empleado.getId());
	}
	
	@Test
    public void testGetSetNombre() {
        empleado.setPrimerNombre("Juan");
        assertEquals("Juan", empleado.getPrimerNombre());
    }
	
	@Test
	public void testGetSetSegundoNombre() {
		empleado.setSegundoNombre("Manuel");
		assertEquals("Manuel",empleado.getSegundoNombre());
	}
	
	@Test
	public void testGetSetApellidoPaterno() {
		empleado.setApellidoPaterno("Camacho");
		assertEquals("Camacho",empleado.getApellidoPaterno());
	}
	
	@Test
	public void testGetSetApellidoMaterno() {
		empleado.setApellidoMaterno("Dominguez");
		assertEquals("Dominguez",empleado.getApellidoMaterno());
	}
	
    @Test
    public void testGetSetEdad() {
        empleado.setEdad(30);
        assertEquals(30, empleado.getEdad());
    }
    
    @Test
    public void testGetSetSexo() {
    	empleado.setSexo("Masculino");
		assertEquals("Masculino",empleado.getSexo());
	}
    
    @Test
	public void testGetSetFechaNacimiento() throws ParseException {
    	SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
    	empleado.setFechaNacimiento(formatoFecha.parse("15-04-1995"));
		assertEquals("15-04-1995",empleado.getFechaNacimiento());
	}
	
	@Test
	public void testGetSetPuesto() {
		empleado.setPuesto("Director");
		assertEquals("Director",empleado.getPuesto());
	}
	
}
