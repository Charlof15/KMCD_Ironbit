package com.ironbit.app.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.ironbit.app.entity.Empleado;
import com.ironbit.app.service.BitacoraService;
import com.ironbit.app.service.EmpleadosService;
import com.ironbit.app.utillities.OpenApiConfig;

@OpenApiConfig
@RestController
@RequestMapping("empleado")
public class EmpleadosController {
	
	@Autowired private EmpleadosService empleadosService;
	@Autowired private BitacoraService bitacoraService;
	private static final Gson GSON_API = new Gson(); 
    


	public EmpleadosController(EmpleadosService empleadosService, BitacoraService bitacoraService) {
		this.empleadosService = empleadosService;
		this.bitacoraService = bitacoraService;
	}

	@GetMapping
    public ResponseEntity<?> empleados(){
		ResponseEntity<?> res = empleadosService.getEmpleados();
    	bitacoraService.registraEvento("NA", GSON_API.toJson(res), "getEmpleados", res.getStatusCode().toString());
    	return res;
    }

    @DeleteMapping(value = "/{idEmpleado}")
    public ResponseEntity<?> empleados(@PathVariable Long idEmpleado){
    	ResponseEntity<?> res = empleadosService.deleteEmpleados(idEmpleado);
    	bitacoraService.registraEvento(GSON_API.toJson(idEmpleado), GSON_API.toJson(res), "deleteEmpleados", res.getStatusCode().toString());
    	return res;
    }

    @PatchMapping(value = "/{idEmpleado}")
    public ResponseEntity<?> empleados(@PathVariable Long idEmpleado,@RequestBody Map<String,Object> empleadoInfo){
    	ResponseEntity<?> res = empleadosService.updateEmpleados(idEmpleado,empleadoInfo);
    	bitacoraService.registraEvento(GSON_API.toJson(empleadoInfo),GSON_API.toJson(res), "updateEmpleados", res.getStatusCode().toString());
    	return res;
    }

    @PostMapping
    public ResponseEntity<?> empleados(@RequestBody ArrayList<Empleado> empleados){
    	ResponseEntity<?> res = empleadosService.createEmpleados(empleados);
    	bitacoraService.registraEvento(GSON_API.toJson(empleados), GSON_API.toJson(res), "createEmpleados", res.getStatusCode().toString());
    	return res;
    }
 }