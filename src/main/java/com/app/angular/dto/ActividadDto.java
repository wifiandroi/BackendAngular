package com.app.angular.dto;

import javax.validation.constraints.NotNull;

public class ActividadDto {

	private String nombre;

	private String apellido;

	private boolean precio;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public boolean isPrecio() {
		return precio;
	}

	public void setPrecio(boolean precio) {
		this.precio = precio;
	}
	
	public ActividadDto(String nombre, String apellido, boolean precio) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.precio = precio;
	}

	public ActividadDto() {
	}

}
