package com.course.manageperson.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.course.manageperson.entities.Enseignant;
import com.course.manageperson.exception.UserNotFoundException;
import com.course.manageperson.services.EnseignantServiceDB;

/**
 *  @author Pro
 * 
 */

@RestController
public class EnseignantController {
		
	private EnseignantServiceDB serv ;
	
	public EnseignantController(EnseignantServiceDB serv) {
		this.serv=serv;
	}
	
	/**
	 * Get all {@Link Enseignant}.
	 * 
	 * @return the list of {@Enseignant}. otherwise {@Code null}
	 */
	@GetMapping("/enseignants")
	List<Enseignant> getEnseignants(){
		return this.serv.getEnseignant();
	}
	
	
	
	/**
	 * Get Enseignant by matricule
	 * 
	 * @param matricule - enseignant matricule
	 * @return {@Enseignant}. otherwise {@null}
	 */
	@GetMapping("/enseignants/byMatricule")
	public Enseignant getEnseignantByMatricule(@RequestParam String matricule) {
		
		return this.serv.getEnseignantByMatricule(matricule);
	}
	 
	
	/**
	 * Get Enseignant by idi
	 * 
	 * @param idi - enseignant id
	 * @return {@Enseignant}. otherwise {@null}
	 * @throws EnseignantNotFoundException
	 */
	@GetMapping("/enseignants/{idi}")
	public Enseignant getEnseignantById(@PathVariable int idi) throws UserNotFoundException {
		
		return this.serv.getEnseignantById(idi);
	}
	
	
	/**
	 * Delete Enseignant by idi
	 * 
	 * @param idi - enseignant id
	 * @return {@Enseignant} delete.  otherwise {@null}
	 * @throws EnseignantNotFoundException 
	 */
	@DeleteMapping("/enseignants/{idi}")
	public Enseignant deleteEnseignantById(@PathVariable int idi) throws UserNotFoundException {
		
		return this.serv.deleteEnseignantById(idi);
	}
	
	
	
	/**
	 * Create new Enseignant
	 * 
	 * @param es - Enseignant
	 * @return {@Enseignant} deleted.  otherwise {@null}
	 */
	@PostMapping("/enseignants")
	public Enseignant saveEnseignant(@RequestBody Enseignant es) {
		
		return this.serv.saveEnseignant(es);
		
	}
	
	
	
	/**
	 * Update {@Enseignant} by idi
	 * 
	 * @param idi - enseignant id
	 * @param es - enseignant
	 * @return {@Enseignant} updated. otherwise {@null}
	 * @throws EnseignantNotFoundException 
	 */
	@PutMapping("/enseignants/{idi}")
	public Enseignant updateEnseignant(@PathVariable int idi,@RequestBody Enseignant es ) throws UserNotFoundException {
		
		return this.serv.updateEnseignant(idi, es);
	}

}
