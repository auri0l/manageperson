package com.course.manageperson.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.course.manageperson.entities.Enseignant;

/**
 * @author Pro
 */

@Service
public class EnseignantService implements IEnseignantService {

	List<Enseignant> enseignants = new ArrayList<>();

	public EnseignantService() {
		this.enseignants = List.of(new Enseignant("UDS001", "SOH", 78, "Dr"),
				new Enseignant("UDS002", "RHOH", 30, "Pr"), new Enseignant("UDS003", "SPOH", 57, "Dr"));
	}

	/**
	 * Get all {@link Enseignant}
	 * 
	 * @return list of {@link Enseignant}. otherwise {@Code null}
	 */
	@Override
	public List<Enseignant> getEnseignant() {

		return this.enseignants;
	}

	/**
	 * Get {@link Enseignant} by matricule
	 * 
	 * @param matricule - enseignant matricule
	 * @return {@link Enseignant}. otherwise {@Code null}
	 */
	@Override
	public Enseignant getEnseignantByMatricule(String matricule) {

		Enseignant enseignants = null;

		for (Enseignant esg : this.enseignants) {

			if (esg.getMatricule().equalsIgnoreCase(matricule)) {
				enseignants = esg;
			}
		}
		return enseignants;
	}

	/**
	 * Get {@link Enseignant} by idi
	 * 
	 * @param idi - enseignant id
	 * @return {@link Enseignant}. otherwise {@Code null}
	 */
	@Override
	public Enseignant getEnseignantById(int idi) {

		Enseignant ens = null;

		for (Enseignant ie : enseignants) {
			if (ie.getIdi() == idi) {

				ens = ie;
			}
		}
		return ens;

	}

	

	/**
	 * Delete {@link Enseignant} by idi.
	 * 
	 * @param idi - enseignant id
	 * @return {@link Enseignant} deleted. otherwise {@Code null}
	 */
	@Override
	public Enseignant deleteEnseignantById(int idi) {

		Enseignant es = null;
		int pos = this.getPositionOfEnseignant(idi);
		if (pos != -1) {
			es = this.enseignants.get(pos);
			this.enseignants.remove(pos);
			return es;
		}
		return null;

	}

	/**
	 * Get {@link Enseignant} position
	 * 
	 * @param idi - enseignant id
	 * @return position of the element in the list otherwise -1.
	 */
	private int getPositionOfEnseignant(int idi) {
		int pos = -1;
		int i = -1;
		for (Enseignant ie : enseignants) {
			i = i + 1;
			if (ie.getIdi() == idi) {
				pos = i;
			}
		}
		return pos;

	}

	

	/**
	 * Create new Enseignant
	 * 
	 * @param es - Enseignant
	 * @return {@link Enseignant} deleted. otherwise {@Code null}
	 */
	@Override
	public Enseignant saveEnseignant(Enseignant es) {

		int totalElement = this.enseignants.size();

		es.setIdi(totalElement);

		this.enseignants.add(es);

		return es;

	}

	/**
	 * Update {@link Enseignant} by idi
	 * 
	 * @param idi - enseignant id
	 * @param es  - enseignant
	 * @return {@Enseignant} updated. otherwise {@Code null}
	 */
	@Override
	public Enseignant updateEnseignant(int idi, Enseignant es) {

		int post = this.getPositionOfEnseignant(idi);
		if (post != -1) {
			Enseignant ess = this.enseignants.get(post);
			if (ess.getIdi() == es.getIdi()) {
				this.enseignants.add(post, es);
				return es;
			}
		}

		return null;

	}

	@Override
	public Enseignant getEnseignantByQuery(String query) {
		// TODO Auto-generated method stub
		return null;
	}

}
