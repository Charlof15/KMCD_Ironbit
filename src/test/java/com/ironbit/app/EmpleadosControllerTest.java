package com.ironbit.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ironbit.app.controller.EmpleadosController;
import com.ironbit.app.entity.Empleado;
import com.ironbit.app.service.BitacoraService;
import com.ironbit.app.service.EmpleadosService;

class EmpleadosControllerTest {

	@InjectMocks
    private EmpleadosController empleadosController;

    @Mock
    private EmpleadosService empleadosService;
    
    @Mock
    private BitacoraService bitacoraService;

    @SuppressWarnings("deprecation")
	@BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        empleadosController = new EmpleadosController(empleadosService, bitacoraService);
    }
    
    @Test
    public void testEmpleados() throws ParseException {
        when(empleadosService.getEmpleados()).thenReturn(new ResponseEntity<>(HttpStatus.OK));
        ResponseEntity<?> response = empleadosController.empleados();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(empleadosService, times(1)).getEmpleados();
    }
    
    @Test
    public void testEliminarEmpleado() throws ParseException {
        Long idEmpleado = 1L;
        when(empleadosService.deleteEmpleados(idEmpleado)).thenReturn(new ResponseEntity<>(HttpStatus.OK));
        ResponseEntity<?> response = empleadosController.empleados(idEmpleado);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(empleadosService, times(1)).deleteEmpleados(idEmpleado);
    }
    
    @Test
    public void testActualizarEmpleado() throws ParseException {
        Long idEmpleado = 1L;
        Map<String, Object> empleadoInfo = new HashMap<>();
        empleadoInfo.put("nombre", "Nuevo Nombre");
        when(empleadosService.updateEmpleados(idEmpleado, empleadoInfo)).thenReturn(new ResponseEntity<>(HttpStatus.OK));
        ResponseEntity<?> response = empleadosController.empleados(idEmpleado, empleadoInfo);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(empleadosService, times(1)).updateEmpleados(idEmpleado, empleadoInfo);
    }
    
    @Test
    public void testCrearEmpleados() throws ParseException {
        ArrayList<Empleado> empleados = new ArrayList<>();
        when(empleadosService.createEmpleados(empleados)).thenReturn(new ResponseEntity<>(HttpStatus.CREATED));
        ResponseEntity<?> response = empleadosController.empleados(empleados);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        verify(empleadosService, times(1)).createEmpleados(empleados);
    }

}
