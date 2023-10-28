package com.ironbit.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ironbit.app.entity.Bitacora;
import com.ironbit.app.repository.BitacoraRepository;
import com.ironbit.app.service.BitacoraService;

@RunWith(MockitoJUnitRunner.class)
class BitacoraServiceTest {
	@InjectMocks
    private BitacoraService bitacoraService;

    @Mock
    private BitacoraRepository bitacoraRepository;
    
    @SuppressWarnings("deprecation")
	@BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        bitacoraService = new BitacoraService(bitacoraRepository);
    }

    @Test
    @SuppressWarnings("unchecked")
	public void testGetBitacora() {
        List<Bitacora> bitacoraList = new ArrayList<>();
        bitacoraList.add(new Bitacora("test","test","test","test",new Date()));
        when(bitacoraRepository.findAll()).thenReturn(bitacoraList);
        ResponseEntity<?> responseEntity = bitacoraService.getBitacora();
        verify(bitacoraRepository).findAll();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        List<Bitacora> listBitacora = (List<Bitacora>) bitacoraService.getBitacora().getBody();
        assertNotNull(listBitacora.get(0).getFechaEjecucion());
    }

    @Test
    public void testRegistraEvento() {
        String input = "entrada de prueba";
        String output = "salida de prueba";
        String metodo = "método de prueba";
        String httpCode = "200";
        bitacoraService.registraEvento(input, output, metodo, httpCode);
        verify(bitacoraRepository).save(argThat(bitacora -> {
            return input.equals(bitacora.getInput()) &&
                   output.equals(bitacora.getOutput()) &&
                   metodo.equals(bitacora.getMetodo()) &&
                   httpCode.equals(bitacora.getHttpCodeResponse());
        }));
    }
}
