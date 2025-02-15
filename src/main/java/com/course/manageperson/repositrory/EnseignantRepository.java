package com.course.manageperson.repositrory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.course.manageperson.entities.Enseignant;

@Repository
public interface EnseignantRepository extends JpaRepository<Enseignant, Integer> {

}
