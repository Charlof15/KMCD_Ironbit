package com.ironbit.app.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.ironbit.app.utillities.CustomDateDeserializer;

@Entity
public class Bitacora {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String metodo;
	@Lob
	private String input;
	@Lob
	private String output;
	private String httpCodeResponse;
	@Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @JsonDeserialize(using = CustomDateDeserializer.class)
	private Date fechaEjecucion;
	
	public Bitacora(String metodo, String input, String output, String httpCodeResponse, Date fechaEjecucion) {
		super();
		this.metodo = metodo;
		this.input = input;
		this.output = output;
		this.httpCodeResponse = httpCodeResponse;
		this.fechaEjecucion = fechaEjecucion;
	}
	
	public Bitacora() {
		super();
	}
	
	public String getMetodo() {
		return metodo;
	}
	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}
	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
	public String getOutput() {
		return output;
	}
	public void setOutput(String output) {
		this.output = output;
	}
	public String getHttpCodeResponse() {
		return httpCodeResponse;
	}
	public void setHttpCodeResponse(String httpCodeResponse) {
		this.httpCodeResponse = httpCodeResponse;
	}
	public String getFechaEjecucion() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(fechaEjecucion);
	}
	public void setFechaEjecucion(Date fechaEjecucion) {
		this.fechaEjecucion = fechaEjecucion;
	}
	
}
