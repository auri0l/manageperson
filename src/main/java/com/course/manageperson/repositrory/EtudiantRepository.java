package com.course.manageperson.repositrory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.course.manageperson.entities.Etudiant;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {

	Etudiant findByNom(String name);


	@Query("select etud from Etudiant etud where etud.nom like %:query%")
	Etudiant findByQuery(String query);
}
