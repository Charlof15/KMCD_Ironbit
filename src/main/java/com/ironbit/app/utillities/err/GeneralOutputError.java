package com.ironbit.app.utillities.err;

import io.swagger.v3.oas.annotations.media.Schema;

public class GeneralOutputError {
	@Schema(name = "mensaje",description = "Mensaje de ejecución")
	private String mensaje = "Operación exitosa";
	
	@Schema(name = "instancia",description = "Instancia que procesa la petición")
	private String code;

	
	public GeneralOutputError(String mensaje, String code) {
		super();
		this.mensaje = mensaje;
		this.code = code;
	}
	
	

	public GeneralOutputError() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	
	
}
