package com.course.manageperson.services;

import java.util.List;

import com.course.manageperson.entities.Etudiant;
import com.course.manageperson.exception.UserNotFoundException;
;public interface IEtudiantService {
	
	public List<Etudiant> getEtudiants();
	public Etudiant getEtudiantByName(String name);
	public Etudiant getEtudiantById(int id) throws UserNotFoundException;
	public Etudiant deleteEtudiantById(int id) throws Exception;
	public Etudiant saveEtudiant(Etudiant e);
	public Etudiant updateEtudiant(int id, Etudiant e) throws Exception;
	public Etudiant getEtudiantByQuery(String query);
	
	/*  "id": 0,
    "nom": "SOH",
    "matricule": "UDS001",
    "filiere": "fs",
    "faculte": "Dr",
    "niveau":2 
    
	{"id":0,
		"nom":"prtro",
		"matricule":"CMUDS-45454001",
		"filiere":"inffddo",
		"faculte":"FS",
		"niveau":12} */

}
