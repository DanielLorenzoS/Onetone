package com.onetone.controllers;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.onetone.entities.Alumno;
import com.onetone.exceptions.ResourceNotFoundException;
import com.onetone.reporitories.AlumnoRepository;

@RestController
@RequestMapping("/alumno")
public class AlumnoController {

	@Autowired
	AlumnoRepository alumnoRepository;

	@GetMapping("/alumno")
	public List<Alumno> findAlumnos() {
		return alumnoRepository.findAll();
	}

	@GetMapping("/alumno/{id}")
	public ResponseEntity<Alumno> watchCredencial(@PathVariable Long id) {
		Alumno alumno = alumnoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Alumno con el ID: " + id + "no encontrado"));
		return ResponseEntity.ok().body(alumno);
	}

	@PostMapping("/alumno")
	public Alumno saveAlumno(@Valid @RequestBody Alumno alumno) {
		return alumnoRepository.save(alumno);
	}

	@PutMapping("/alumno/{id}")
	public ResponseEntity<Alumno> updateAlumno(@PathVariable Long id, @Valid @RequestBody Alumno alumnoC) {
		Alumno alumno = alumnoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Alumno con el ID: " + id + "no encontrado"));
		alumno.setStatus(alumnoC.getStatus());
		Alumno alumnoUpdated = alumnoRepository.save(alumno);
		return ResponseEntity.ok(alumnoUpdated);
	}
	
	@DeleteMapping("/alumno/{id}")
	public Map<String, Boolean> deleteAlumno(@PathVariable Long id){
		Alumno alumno = alumnoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Alumno con el ID: " + id + "no encontrado"));
		alumnoRepository.delete(alumno);
		Map<String, Boolean> res = new HashMap<>();
		res.put("Alumno eliminado", Boolean.TRUE);
		return res;
	}
}







