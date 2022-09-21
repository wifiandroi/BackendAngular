package com.app.angular.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.angular.dto.ActividadDto;
import com.app.angular.entity.Actividad;
import com.app.angular.global.exceptions.ResourceNotFoundException;
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
//	public Actividad getOne(int id) {
//	return actividadRepository.findById(id).get();	
	public Actividad getOne(int id) throws ResourceNotFoundException {
		return actividadRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No exite el ID"));
	}

	//Metodo Guardar
	public Actividad save(ActividadDto dto) {
//		if (actividadRepository.existsByName(dto.getNombre())) 
//			throw new AttributeException("el nombre ya exite");
		 		
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
//	public Actividad update(int id, ActividadDto dto) {
//	Actividad actividad = actividadRepository.findById(id).get();	
   public Actividad update(int id, ActividadDto dto) throws ResourceNotFoundException {		
		Actividad actividad = actividadRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Sin actualizar"));
		
//		if(actividadRepository.existsByName(dto.getNombre()) && actividadRepository.findByName(dto.getNombre()).get().getId() != id)
//			throw new AttributeException("el nombre ya exite");
		
		actividad.setNombre(dto.getNombre());
		actividad.setApellido(dto.getApellido());
		actividad.setPrecio(dto.getPrecio());
		return actividadRepository.save(actividad);
	}
	
	//Metodo Eliminar
//	public Actividad delete(int id) {
//	Actividad actividad = actividadRepository.findById(id).get();  
		public Actividad delete(int id) throws ResourceNotFoundException {		
		Actividad actividad = actividadRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Sin Borrar"));
		actividadRepository.delete(actividad);
		return actividad;
	}

}
