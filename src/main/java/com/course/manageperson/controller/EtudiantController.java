package com.course.manageperson.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
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
import com.course.manageperson.exception.UserNotFoundException;
import com.course.manageperson.services.EtudiantService;
import com.course.manageperson.services.EtudiantServiceDB;

/**
 * @author Le Pro
 */
@RestController
public class EtudiantController {
	
	private EtudiantServiceDB service;
	
	public EtudiantController(EtudiantServiceDB service) {	
		this.service = service;
	}

	/**
	 * Get all {@Link Etudiant}s.
	 * 
	 * @return the list of {@Etudiant}. otherwise {@Code null}
	 */
	@GetMapping("/etudiants")
	public ResponseEntity<List<Etudiant>> getEtudiants() {
		return ResponseEntity.ok(this.service.getEtudiants());
	}
	
	/**
	 * Get {@Etudiant} by name.
	 * 
	 * @param name - The student name
	 * @return the {@Etudiant}. otherwise {@null}
	 */
	@GetMapping("/etudiants/byName")
	public ResponseEntity<Etudiant> getEtudiantByName(@RequestParam String name) {
		return ResponseEntity.ok(this.service.getEtudiantByName(name));
	}
	
	/**
	 * Get {@Etudiant} by name.
	 * 
	 * @param query - The query
	 * @return the {@Etudiant}. otherwise {@null}
	 */
	@GetMapping("/etudiants/byQuery")
	public ResponseEntity<Etudiant> getEtudiantByQuery(@RequestParam String query) {
		return ResponseEntity.ok(this.service.getEtudiantByQuery(query));
	}
	
	/**
	 * Get {@Etudiant} by id.
	 * 
	 * @param id - The student id
	 * @return the {@Etudiant}. otherwise {@null}
	 */
	@GetMapping("/etudiants/{id}")
	public ResponseEntity<Etudiant> getEtudiantById(@PathVariable int id) {
		Etudiant etudiant = null;
		try {
			etudiant = this.service.getEtudiantById(id) ;	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(etudiant);
	}
	
	/**
	 * Delete {@Etudiant} by id.
	 * 
	 * @param id - The student id
	 * @return the {@Etudiant} deleted. otherwise {@null}
	 * @throws UserNotFoundException 
	 */
	@DeleteMapping("/etudiants/{id}")
	public ResponseEntity<Etudiant> deleteEtudiantById(@PathVariable int id) throws UserNotFoundException {
		return ResponseEntity.ok(this.service.deleteEtudiantById(id));
	}
	
	/**
	 * Create new {@Etudiant}.
	 * 
	 * @param e - The student
	 * @return the {@Etudiant} created. otherwise {@null}
	 */
	@PostMapping("/etudiants")
	public ResponseEntity<Etudiant> saveEtudiant(@RequestBody Etudiant e) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.saveEtudiant(e));
	}
	
	/**
	 * Update {@Etudiant}.
	 * 
	 * @param id - The student id
	 * @param e - The student
	 * @return the {@Etudiant} updated. otherwise {@null}
	 */
	@PutMapping("/etudiants/{id}")
	public ResponseEntity<Etudiant> updateEtudiant(@PathVariable int id,@RequestBody Etudiant e ) throws UserNotFoundException {
		return ResponseEntity.ok(this.service.updateEtudiant(id,e));
	}

}
