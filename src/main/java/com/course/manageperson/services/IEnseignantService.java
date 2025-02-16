package com.course.manageperson.services;
import java.util.List;

import com.course.manageperson.entities.Enseignant;
import com.course.manageperson.exception.UserNotFoundException;



public interface IEnseignantService {
	
	public List<Enseignant> getEnseignant(); 
	
	public Enseignant getEnseignantByMatricule(String matricule);
	
	public Enseignant getEnseignantById(int idi) throws UserNotFoundException ;
	
	public Enseignant deleteEnseignantById(int idi) throws UserNotFoundException ;
	
	public Enseignant saveEnseignant(Enseignant es);
	
	public Enseignant updateEnseignant(int idi, Enseignant es) throws UserNotFoundException ;

	public Enseignant getEnseignantByQuery(String query); 
	
}