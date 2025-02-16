package com.course.manageperson.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.course.manageperson.entities.Enseignant;
import com.course.manageperson.exception.UserNotFoundException;
import com.course.manageperson.repositrory.EnseignantRepository;

@Service
public class EnseignantServiceDB implements IEnseignantService {

	private EnseignantRepository reposit;

	public EnseignantServiceDB(EnseignantRepository reposit) {
		super();
		this.reposit = reposit;
	}

	@Override
	public List<Enseignant> getEnseignant() {

		return this.reposit.findAll();
	}

	/**
	 * Get {@Enseignqnt} by query.
	 * 
	 * @param name - The query
	 * @return the {@Enseignqnt}. otherwise {@null}
	 */

	@Override
	public Enseignant getEnseignantByMatricule(String matricule) {

		return this.reposit.findBymatricule(matricule);
	}

	@Override
	public Enseignant getEnseignantById(int idi) throws UserNotFoundException {
		Optional<Enseignant> ens = this.reposit.findById(idi);
		if (ens.isPresent()) {
			return ens.get();
		}
		throw new UserNotFoundException("Enseignant not found with " + idi);
	}

	@Override
	public Enseignant deleteEnseignantById(int idi) throws UserNotFoundException {

		Optional<Enseignant> ens = this.reposit.findById(idi);
		if (ens.isPresent()) {
			reposit.deleteById(idi);
			return ens.get();
		}

		throw new UserNotFoundException("Enseignant not found with " + idi);
	}

	@Override
	public Enseignant saveEnseignant(Enseignant es) {

		return this.reposit.save(es);
	}

	@Override
	public Enseignant updateEnseignant(int idi, Enseignant es) throws UserNotFoundException {

		Optional<Enseignant> ens = this.reposit.findById(idi);
		if (ens.isPresent() && idi == es.getIdi()) {
			return this.reposit.save(es);
		}
		throw new UserNotFoundException("Enseignant not found with " + idi);
	}

	@Override
	public Enseignant getEnseignantByQuery(String query) {

		return this.reposit.findByQuery(query);

	}

}
