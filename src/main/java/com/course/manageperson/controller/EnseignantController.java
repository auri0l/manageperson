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
import com.course.manageperson.entities.Etudiant;
import com.course.manageperson.services.EnseignantService;
import com.course.manageperson.services.EnseignantServiceDB;


@RestController
public class EnseignantController {
	
private EnseignantServiceDB serv ;

public EnseignantController(EnseignantServiceDB serv) {
	this.serv=serv;
}

@GetMapping("/enseignants")
List<Enseignant> getEnseignants(){
	return this.serv.getEnseignant();
}

@GetMapping("enseignants/byMatricule")
public Enseignant getEnseignantByMatricule(@RequestParam String matricule) {
	
	return this.serv.getEnseignantByMatricule(matricule);
}
@GetMapping("/enseignants/{id}")
public Enseignant getEnseignantById(@PathVariable int idi) {
	
	return this.serv.deleteEnseignantById(idi);
}

@DeleteMapping("/enseignants/{id}")
public Enseignant deleteEnseignantById(@PathVariable int idi) {
	
	return this.serv.deleteEnseignantById(idi);
}

@PostMapping("/enseignants")
public Enseignant saveEnseignant(@RequestBody Enseignant es) {
	
	return this.serv.saveEnseignant(es);
	
}

@PutMapping("/enseignants/{id}")
public Enseignant updateEnseignant(@PathVariable int idi,@RequestBody Enseignant es ) {
	
	return this.serv.updateEnseignant(idi, es);
}

}
