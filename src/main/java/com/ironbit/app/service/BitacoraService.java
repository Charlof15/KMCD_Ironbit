package com.ironbit.app.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ironbit.app.entity.Bitacora;
import com.ironbit.app.repository.BitacoraRepository;

@Service
public class BitacoraService {
	
	@Autowired private BitacoraRepository bitacoraRepository;
	
	public BitacoraService(BitacoraRepository bitacoraRepository) {
		this.bitacoraRepository = bitacoraRepository;
	}

	/**
	 * Metodo para consultar los movimientos en el api
	 * @return ResponseEntity con una lista de empleados y el código de estado HTTP 200 (OK) si la consulta es exitosa.
	 * @throws DataAccessException Si ocurre un error al acceder a la base de datos.
	 * @author: Karla Monstserrat Camacho Dominguez
	 * @version: 1.0 - 2023-10-25
	 */
    public ResponseEntity<?> getBitacora(){
        List<Bitacora> bitacora = bitacoraRepository.findAll();
        return new ResponseEntity<>(bitacora, HttpStatus.OK);
    }
    
    public void registraEvento(String input,String output,String metodo,String httpCode) {
    	Bitacora bitacora = new Bitacora();
    	bitacora.setInput(input);
    	bitacora.setOutput(output);
    	bitacora.setMetodo(metodo);
    	bitacora.setHttpCodeResponse(httpCode);
    	bitacora.setFechaEjecucion(new Date());
    	bitacoraRepository.save(bitacora);
    }
}
