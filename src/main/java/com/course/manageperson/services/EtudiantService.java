package com.course.manageperson.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.course.manageperson.entities.Etudiant;

@Service
public class EtudiantService implements IEtudiantService {
	
	/**
	 * Create list of student
	 * 
	 * @return the list of student
	 */
	
	List<Etudiant> etudiants = new ArrayList<>();

	public EtudiantService() {
		
		this.etudiants.add(new Etudiant(1,"pro", "CMUDS-001", "info", "FS", 1));
		this.etudiants.add(new Etudiant(2,"kro", "CMUDS-002", "info", "FS", 2));
		this.etudiants.add(new Etudiant(3,"bro", "CMUDS-003", "info", "FS", 3));
	}

	
	

	/**
	 * Get all {@Etudiant}.
	 * 

	 * @return list of {@Etudiant}. otherwise {@null}
	 */
	@Override
	public List<Etudiant> getEtudiants() {
		
		return this.etudiants;
	}

	

	/**
	 * Get {@Etudiant} by name.
	 * 
	 * @param name - The student name
	 * @return the {@Etudiant}. otherwise {@null}
	 */
	@Override
	public Etudiant getEtudiantByName(String name) {
		
		Etudiant etudiant = null;
		
		for (Etudiant et : this.etudiants) {
			if (et.getNom().equalsIgnoreCase(name)) {
				etudiant =  et;
			}
		}
		return etudiant;
	}
	
	
	/**
	 * Get {@Etudiant} by id.
	 * 
	 * @param id - The student id
	 * @return the {@Etudiant}. otherwise {@null}
	 */
	@Override
	public Etudiant getEtudiantById(int id) {
		
		Etudiant etudiant = null;
		
		for (Etudiant idi : etudiants) {
			if (idi.getId() == id) {
				
				etudiant = idi; 
			} 
		}
		return etudiant;	
	}

	
	
	/**
	 * Delete {@Etudiant} by id.
	 * 
	 * @param id - The student id
	 * @return the {@Etudiant} deleted. otherwise {@null}
	 */
	public Etudiant deleteEtudiantById(int id) {
		Etudiant e = null;
		int pos = this.getPositionOfEtudiant(id);
		if (pos != -1) {
			e = this.etudiants.get(pos);
			this.etudiants.remove(pos);
			return e;
		}
		return null;
	}
	
	
	
	/**
	 * Get etudiant position
	 * 
	 * @param id - The student id
	 * @return the student position
	 */
	private int getPositionOfEtudiant(int id) {
		int pos = -1;
		int i = -1;
		for (Etudiant idi : etudiants) {
			i = i+1;
			if (idi.getId() == id) {
				pos = i;
			} 
		}
		return pos;	
	}

	
	/**
	 * Create new {@Etudiant}.
	 * 
	 * @param e - The student
	 * @return the {@Etudiant} created. otherwise {@null}
	 */
	public Etudiant saveEtudiant(Etudiant e) {
		int totalElement = this.etudiants.size();
		
		e.setId(totalElement);
		
		this.etudiants.add(e);
		
		return e;
	}

	
	/**
	 * Update {@Etudiant}.
	 * 
	 * @param id - The student id
	 * @param e - The student
	 * @return the {@Etudiant} updated. otherwise {@null}
	 */
	public Etudiant updateEtudiant(int id, Etudiant e) {
		int post = this.getPositionOfEtudiant(id);
		if (post != -1) {
			Etudiant etud = this.etudiants.get(post);
			if (etud.getId() == e.getId()) {
				this.etudiants.add(post, e);
				return e;
			}
		}
		
		return null;
	}




	@Override
	public Etudiant getEtudiantByQuery(String query) {
		// TODO Auto-generated method stub
		return null;
	}
}
		
		
		
		
			
			
	
		
	
	
	
	


