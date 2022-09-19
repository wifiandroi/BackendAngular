package com.app.angular.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.angular.dto.ActividadDto;
import com.app.angular.entity.Actividad;
import com.app.angular.repository.ActividadRepository;

@Service
public class ActividadService {

	@Autowired
	ActividadRepository actividadRepository;

	//Metodo listar
	public List<Actividad> getAll() {
		return actividadRepository.findAll();
	}

	//Metodo buscar por ID
	public Actividad getOne(int id) {
		return actividadRepository.findById(id).get();
	}

	//Metodo Guardar
	public Actividad save(ActividadDto dto) {
		int id = autoIncrement();
		Actividad actividad = new Actividad(id, dto.getNombre(), dto.getApellido(), dto.getPrecio());
		return actividadRepository.save(actividad);
	}

	//Función del Metodo Guardar
	private int autoIncrement() {
		List<Actividad> actividades = actividadRepository.findAll();
		return actividades.isEmpty() ? 1
				: actividades.stream().max(Comparator.comparing(Actividad::getId)).get().getId() + 1;
	}
	
	//Metodo Actualizar
	public Actividad update(int id, ActividadDto dto) {
		Actividad actividad = actividadRepository.findById(id).get();
		actividad.setNombre(dto.getNombre());
		actividad.setApellido(dto.getApellido());
		actividad.setPrecio(dto.getPrecio());
		return actividadRepository.save(actividad);
	}
	
	//Metodo Eliminar
	public Actividad delete(int id) {
		Actividad actividad = actividadRepository.findById(id).get();
		actividadRepository.delete(actividad);
		return actividad;
	}

}
