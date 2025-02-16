package com.course.manageperson.repositrory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.course.manageperson.entities.Enseignant;
import com.course.manageperson.entities.Etudiant;

@Repository
public interface EnseignantRepository extends JpaRepository<Enseignant, Integer> {

	Enseignant findBymatricule(String matricule);

	

	@Query("select ens from Enseignant ens where ens.nom like %:query%")
	Enseignant findByQuery(String query);

}
