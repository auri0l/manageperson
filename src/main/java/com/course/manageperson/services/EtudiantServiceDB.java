package com.course.manageperson.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.course.manageperson.entities.Etudiant;
import com.course.manageperson.exception.UserNotFoundException;
import com.course.manageperson.repositrory.EtudiantRepository;

@Service
public class EtudiantServiceDB implements IEtudiantService {
	
	private EtudiantRepository repository;
	
	public EtudiantServiceDB(EtudiantRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public Etudiant deleteEtudiantById(int id) throws UserNotFoundException {
		Optional<Etudiant> etud = this.repository.findById(id);
		if (etud.isPresent()) {
			repository.deleteById(id);
			return etud.get();
		}
		throw new UserNotFoundException("Etudiant not found with "+id);
	}

	@Override
	public Etudiant saveEtudiant(Etudiant e) {
		return repository.save(e);
	}

	@Override
	public Etudiant updateEtudiant(int id, Etudiant e) throws UserNotFoundException {
		Optional<Etudiant> etud = this.repository.findById(id);
		if (etud.isPresent() && id == e.getId()) {
			return this.repository.save(e);
		}
		throw new UserNotFoundException("Etudiant not found with "+id);
	}

	@Override
	public List<Etudiant> getEtudiants() {
		return this.repository.findAll();
	}

	@Override
	public Etudiant getEtudiantByName(String name) {
		return this.repository.findByNom(name);
	}
	
	/**
	 * Get {@Etudiant} by query.
	 * 
	 * @param name - The query
	 * @return the {@Etudiant}. otherwise {@null}
	 */
	@Override
	public Etudiant getEtudiantByQuery(String query) {
		return this.repository.findByQuery(query);
	}

	@Override
	public Etudiant getEtudiantById(int id) throws UserNotFoundException {
		Optional<Etudiant> etud = this.repository.findById(id);
		if (etud.isPresent()) {
			return etud.get();
		}
		throw new UserNotFoundException("Etudiant not found with "+id);
	}

}
