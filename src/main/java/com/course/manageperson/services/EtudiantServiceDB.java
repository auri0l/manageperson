package com.course.manageperson.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.course.manageperson.entities.Etudiant;
import com.course.manageperson.repositrory.EtudiantRepository;

@Service
public class EtudiantServiceDB implements IEtudiantService {
	
	private EtudiantRepository repository;
	
	public EtudiantServiceDB(EtudiantRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public Etudiant deleteEtudiantById(int id) {
		Optional<Etudiant> etud = this.repository.findById(id);
		if (etud.isPresent()) {
			repository.deleteById(id);
			return etud.get();
		}
		return null;
	}

	@Override
	public Etudiant saveEtudiant(Etudiant e) {
		return repository.save(e);
	}

	@Override
	public Etudiant updateEtudiant(int id, Etudiant e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Etudiant> getEtudiants() {
		
		return this.repository.findAll();
	}

	@Override
	public Etudiant getEtudiantByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Etudiant getEtudiantById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
