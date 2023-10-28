package com.ironbit.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ironbit.app.entity.Empleado;
import com.ironbit.app.repository.EmpleadosRepository;
import com.ironbit.app.service.EmpleadosService;

@RunWith(MockitoJUnitRunner.class)
class EmpleadosServiceTest {
	private EmpleadosRepository empleadoRepository;
    private ModelMapper modelMapper;
    private EmpleadosService empleadosService;

    @BeforeEach
    public void setUp() {
        empleadoRepository = mock(EmpleadosRepository.class);
        modelMapper = mock(ModelMapper.class);
        empleadosService = new EmpleadosService(empleadoRepository, modelMapper);
    }

    @Test
    public void testGetEmpleados() {
        List<Empleado> empleadosEjemplo = new ArrayList<>();
        when(empleadoRepository.findAll()).thenReturn(empleadosEjemplo);
        ResponseEntity<?> response = empleadosService.getEmpleados();
        verify(empleadoRepository, times(1)).findAll();
        HttpStatus expectedStatus = HttpStatus.OK;
        HttpStatus actualStatus = response.getStatusCode();
        assertEquals(expectedStatus, actualStatus);
    }
    
    @Test
    public void testDeleteEmpleados() {
        Long idEmpleadoAEliminar = 1L;
        doNothing().when(empleadoRepository).deleteById(idEmpleadoAEliminar);
        ResponseEntity<?> response = empleadosService.deleteEmpleados(idEmpleadoAEliminar);
        verify(empleadoRepository, times(1)).deleteById(idEmpleadoAEliminar);
        HttpStatus expectedStatus = HttpStatus.NO_CONTENT;
        HttpStatus actualStatus = response.getStatusCode();
        assertEquals(expectedStatus, actualStatus);
    }
    
    @Test
    public void testUpdateEmpleadosNotFound() {
        Long idEmpleado = 1L;
        Map<String, Object> camposActualizar = new HashMap<>();
        camposActualizar.put("nombre", "Nuevo Nombre");
        camposActualizar.put("puesto", "Nuevo Puesto");
        Optional<Empleado> empleadoOptional = Optional.empty();
        when(empleadoRepository.findById(idEmpleado)).thenReturn(empleadoOptional);
        ResponseEntity<?> response = empleadosService.updateEmpleados(idEmpleado, camposActualizar);
        verify(empleadoRepository, times(1)).findById(idEmpleado);
        HttpStatus expectedStatus = HttpStatus.NOT_FOUND;
        HttpStatus actualStatus = response.getStatusCode();
        assertEquals(expectedStatus, actualStatus);
    }
    
    @Test
    public void testUpdateEmpleadosOK() {
        Long idEmpleado = 1L;
        Map<String, Object> camposActualizar = new HashMap<>();
        camposActualizar.put("nombre", "Nuevo Nombre");
        camposActualizar.put("puesto", "Nuevo Puesto");
        Optional<Empleado> empleadoOptional = Optional.of(new Empleado());
        when(empleadoRepository.findById(idEmpleado)).thenReturn(empleadoOptional);
        when(empleadoRepository.save(empleadoOptional.get())).thenReturn(empleadoOptional.get());
        ResponseEntity<?> response = empleadosService.updateEmpleados(idEmpleado, camposActualizar);
        verify(empleadoRepository, times(1)).findById(idEmpleado);
        verify(modelMapper, times(1)).map(camposActualizar, empleadoOptional.get());
        verify(empleadoRepository, times(1)).save(empleadoOptional.get());
        HttpStatus expectedStatus = HttpStatus.OK;
        HttpStatus actualStatus = response.getStatusCode();
        assertEquals(expectedStatus, actualStatus);
    }
    
    @Test
    public void testCreateEmpleados()  throws ParseException {
        List<Empleado> empleadosInsertar = new ArrayList<>();
        empleadosInsertar.add(new Empleado());
        empleadosInsertar.add(new Empleado());
        List<Empleado> empleadosCreados = new ArrayList<>();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        empleadosCreados.add(new Empleado("Juan", "Carlos", "González", "Pérez", 28, "Masculino", formatoFecha.parse("10-05-1995"), "Gerente de Proyectos"));
        empleadosCreados.add(new Empleado("Karla", "Montserrat", "Camacho", "Dominguez", 28, "Masculino", formatoFecha.parse("10-05-1995"), "Gerente de Proyectos"));
        when(empleadoRepository.saveAll(empleadosInsertar)).thenReturn(empleadosCreados);
        ResponseEntity<?> response = empleadosService.createEmpleados((ArrayList<Empleado>) empleadosInsertar);
        verify(empleadoRepository, times(1)).saveAll(empleadosInsertar);
        HttpStatus expectedStatus = HttpStatus.CREATED;
        HttpStatus actualStatus = response.getStatusCode();
        assertEquals(expectedStatus, actualStatus);
    }

}
