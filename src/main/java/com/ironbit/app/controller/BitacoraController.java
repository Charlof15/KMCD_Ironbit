package com.ironbit.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ironbit.app.service.BitacoraService;

@RestController
@RequestMapping("/bitacora")
public class BitacoraController {
	
	@Autowired private BitacoraService bitacoraService;
	
	public BitacoraController(BitacoraService bitacoraService) {
		super();
		this.bitacoraService = bitacoraService;
	}

	@GetMapping
	public ResponseEntity<?> bitacora(){
		return bitacoraService.getBitacora();
	}
 }
