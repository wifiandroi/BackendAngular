package com.app.angular.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class ActividadDto {
	
	@NotBlank(message = "Nombre Obligatorio")
	private String nombre;

	@NotBlank(message = "Apellido Obligatorio")
	private String apellido;

	@Min(value = 1, message = "Debe ingresar un cantidad")
	private float precio;

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

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	public ActividadDto(String nombre, String apellido, float precio) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.precio = precio;
	}

	public ActividadDto() {
	}

}
