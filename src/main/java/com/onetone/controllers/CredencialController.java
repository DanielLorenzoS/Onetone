package com.onetone.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onetone.entities.Credencial;
import com.onetone.reporitories.CredencialRepository;

@RestController
@RequestMapping("/credencial")
public class CredencialController {
	
	@Autowired
	CredencialRepository credencialRepository;
	
	@PostMapping("/")
	public Credencial saveCredencial(@Valid @RequestBody Credencial credencial) {
		return this.credencialRepository.save(credencial);
	}
	
	@GetMapping
	public ArrayList<Credencial> findCredencial() {
		return (ArrayList<Credencial>) credencialRepository.findAll();
	}
}
