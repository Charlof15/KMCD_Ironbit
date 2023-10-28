package com.ironbit.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ironbit.app.entity.Empleado;
import com.ironbit.app.repository.EmpleadosRepository;

@Service
public class EmpleadosService {
	
	@Autowired private EmpleadosRepository empleadoRepository;
	@Autowired private ModelMapper modelMapper;

	
	public EmpleadosService(EmpleadosRepository empleadoRepository, ModelMapper modelMapper) {
		super();
		this.empleadoRepository = empleadoRepository;
		this.modelMapper = modelMapper;
	}


	/**
	 * Metodo para consultar a los empleados dados de alta
	 * @return ResponseEntity con una lista de empleados y el código de estado HTTP 200 (OK) si la consulta es exitosa.
	 * @throws DataAccessException Si ocurre un error al acceder a la base de datos.
	 * @author: Karla Monstserrat Camacho Dominguez
	 * @version: 1.0 - 2023-10-25
	 */
    public ResponseEntity<?> getEmpleados(){
        List<Empleado> empleados = empleadoRepository.findAll();
        return new ResponseEntity<>(empleados, HttpStatus.OK);
    }

    
    /**
	 * Metodo para eliminar empleado por ID
	 * @return ResponseEntity con el código de estado HTTP 204 (NO CONTENT).
	 * @throws DataAccessException Si ocurre un error al acceder a la base de datos.
	 * @author: Karla Monstserrat Camacho Dominguez
	 * @version: 1.0 - 2023-10-25
	 */
    public ResponseEntity<?> deleteEmpleados(Long idEmpleado){
    	empleadoRepository.deleteById(idEmpleado);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    
    /**
	 * Metodo para actualizar empleado
	 * @return ResponseEntity con el código de estado HTTP 404 (NOT FOUND) cuando el id del empleado no existe ne la base de datos.
 	 * @return ResponseEntity con el empleado actualizado y con el código de estado HTTP 200 (OK) cuando se procesa correctamente.
 	 * @throws DataAccessException Si ocurre un error al acceder a la base de datos.
	 * @author: Karla Monstserrat Camacho Dominguez
	 * @version: 1.0 - 2023-10-25
	 */
    public ResponseEntity<?> updateEmpleados(Long idEmpleado,Map<String,Object> camposActualizar){
    	 Optional<Empleado> empleadoOptional = empleadoRepository.findById(idEmpleado);
    	 if (!empleadoOptional.isPresent()) 
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         
    	 modelMapper.map(camposActualizar, empleadoOptional.get());
         Empleado empleadoActualizado = empleadoRepository.save(empleadoOptional.get());
         return new ResponseEntity<>(empleadoActualizado,HttpStatus.OK); 
    }

    /**
	 * Metodo para registrar empleados
 	 * @throws DataAccessException Si ocurre un error al acceder a la base de datos.
	 * @return ResponseEntity con los empleados registrados y con el código de estado HTTP 201 (CREATED) cuando se procesa correctamente.
	 * @author: Karla Monstserrat Camacho Dominguez
	 * @version: 1.0 - 2023-10-25
	 */
    public ResponseEntity<?> createEmpleados(ArrayList<Empleado> empleadosInsertar){
    	List<Empleado> empleadosCreados = empleadoRepository.saveAll(empleadosInsertar);
        return new ResponseEntity<>(empleadosCreados,HttpStatus.CREATED);
    }
}
