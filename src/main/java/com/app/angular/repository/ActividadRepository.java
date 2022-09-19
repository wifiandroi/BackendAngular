package com.app.angular.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.angular.entity.Actividad;

@Repository
public interface ActividadRepository  extends JpaRepository<Actividad, Integer>{

}
