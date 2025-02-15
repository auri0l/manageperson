package com.course.manageperson.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.course.manageperson.entities.Etudiant;
import com.course.manageperson.services.EtudiantService;
import com.course.manageperson.services.EtudiantServiceDB;

@RestController
public class EtudiantController {
	
	private EtudiantServiceDB service;
	
	public EtudiantController(EtudiantServiceDB service) {	
		this.service = service;
	}

	@GetMapping("/etudiants")
	public ResponseEntity<List<Etudiant>> getEtudiants() {
		
		return ResponseEntity.ok(this.service.getEtudiants()) ;
	}
	
	@GetMapping("/etudiants/byName")
	public Etudiant getEtudiantByName(@RequestParam String name) {
		
		return this.service.getEtudiantByName(name) ;
	}
	
	@GetMapping("/etudiants/{id}")
	public Etudiant getEtudiantById(@PathVariable int id) {
		
		return this.service.getEtudiantById(id) ;
	}
	
	@DeleteMapping("/etudiants/{id}")
	public Etudiant deleteEtudiantById(@PathVariable int id) {
		
		return this.service.deleteEtudiantById(id) ;
	}
	
	@PostMapping("/etudiants")
	public Etudiant saveEtudiant(@RequestBody Etudiant e) {
		
		return this.service.saveEtudiant(e) ;
	}
	
	@PutMapping("/etudiants/{id}")
	public Etudiant updateEtudiant(@PathVariable int id,@RequestBody Etudiant e ) {
		
		return this.service.updateEtudiant(id,e) ;
	}
	
	
	
	

}
