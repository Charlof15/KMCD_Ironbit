package com.ironbit.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ironbit.app.controller.BitacoraController;
import com.ironbit.app.repository.BitacoraRepository;
import com.ironbit.app.service.BitacoraService;

@RunWith(MockitoJUnitRunner.class)
class BitacoraControllerTest {
	private BitacoraController bitacoraConytroller;

    @Mock
    private BitacoraRepository bitacoraRepository;
    
    @Mock
    private BitacoraService bitacoraService;
    
    @SuppressWarnings("deprecation")
	@BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.bitacoraConytroller = new BitacoraController(bitacoraService);
    }

    @Test
   	public void testGetFechaEjecucion() {
       when(bitacoraService.getBitacora()).thenReturn(new ResponseEntity<>(HttpStatus.OK));
       ResponseEntity<?> result = bitacoraConytroller.bitacora();
       assertEquals(HttpStatus.OK, result.getStatusCode());
       verify(bitacoraService, times(1)).getBitacora();
    }
}
