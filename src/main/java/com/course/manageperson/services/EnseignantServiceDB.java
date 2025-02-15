package com.course.manageperson.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.course.manageperson.entities.Enseignant;
import com.course.manageperson.repositrory.EnseignantRepository;

@Service
public class EnseignantServiceDB implements IEnseignantService {
	
	private EnseignantRepository reposit ;
	
	public EnseignantServiceDB(EnseignantRepository reposit) {
		super();
		this.reposit = reposit;
	}

	@Override
	public List<Enseignant> getEnseignant() {
		
		return this.reposit.findAll();
	}

	@Override
	public Enseignant getEnseignantByMatricule(String matricule) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Enseignant getEnseignantById(int idi) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Enseignant deleteEnseignantById(int idi) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Enseignant saveEnseignant(Enseignant es) {
		// TODO Auto-generated method stub
		return this.reposit.save(es);
	}

	@Override
	public Enseignant updateEnseignant(int idi, Enseignant es) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
