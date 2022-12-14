package com.app.angular.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.angular.dto.ActividadDto;
import com.app.angular.entity.Actividad;
import com.app.angular.global.Dto.MessageDto;
import com.app.angular.global.exceptions.AttributeException;
import com.app.angular.global.exceptions.ResourceNotFoundException;
import com.app.angular.service.ActividadService;

@RestController
@RequestMapping("/actividad")
public class ActividadController {
	
	@Autowired
	ActividadService actividadService;
	
	@GetMapping
	public ResponseEntity<List<Actividad>> getAll(){
		return ResponseEntity.ok(actividadService.getAll());
	}
	
	@GetMapping("/{id}")
//	public ResponseEntity<Actividad> getOne(@PathVariable("id") int id){
	public ResponseEntity<Actividad> getOne(@PathVariable("id") int id) throws ResourceNotFoundException{		
		return ResponseEntity.ok(actividadService.getOne(id));
	}
	
	@PostMapping
	public ResponseEntity<MessageDto> save(@Valid @RequestBody ActividadDto dto) throws AttributeException{
		Actividad actividad = actividadService.save(dto);
		String message = "actividad "+ actividad.getNombre() + " have been saved";
		return ResponseEntity.ok(new MessageDto(HttpStatus.OK, message));
	}
	
	@PutMapping("/{id}")
//	public ResponseEntity<Actividad> update(@PathVariable("id") int id, @RequestBody ActividadDto dto){
	public ResponseEntity<MessageDto> update(@PathVariable("id") int id, @Valid @RequestBody ActividadDto dto) throws ResourceNotFoundException, AttributeException{		
		Actividad actividad = actividadService.update(id, dto);
		String message = "actividad "+ actividad.getNombre() + " have been updated";
		return ResponseEntity.ok(new MessageDto(HttpStatus.OK, message));
	}
	
	@DeleteMapping("/{id}")
//	public ResponseEntity<Actividad> delete(@PathVariable("id") int id){
	public ResponseEntity<MessageDto> delete(@PathVariable("id") int id) throws ResourceNotFoundException{	
		Actividad actividad = actividadService.delete(id);
		String message = "actividad "+ actividad.getNombre() + " have been deleted";
		return ResponseEntity.ok(new MessageDto(HttpStatus.OK, message));
		
	}
}
