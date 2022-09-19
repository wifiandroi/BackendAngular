package com.app.angular.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "actividades", schema = "manuel")
public class Actividad {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "act_seqact")
	@SequenceGenerator(sequenceName = "act_seqact", allocationSize = 1, name = "act_seqact")
	private int id;

	@NotNull
	@Column(name = "nombres")
	private String nombre;

	@NotNull
	@Column(name = "apellidos")
	private String apellido;

	@NotNull
	@Column(name = "precios")
	private boolean precio;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public Actividad(@NotNull String nombre, @NotNull String apellido, @NotNull boolean precio) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.precio = precio;
	}

	public Actividad() {
	}

}
