package com.app.angular.dto;


public class ActividadDto {

	private String nombre;

	private String apellido;

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
