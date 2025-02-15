package com.course.manageperson.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ETUDIANT")
public class Etudiant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ETUD_ID")
	private int id;
	
	@Column(name = "ETUD_NOM")
	private String nom;
	
	@Column(name = "ETUD_MAT")
	private String matricule;
	
	@Column(name = "ETUD_FI")
	private String filiere;
	
	@Column(name = "ETUD_FAC")
	private String faculte;
	
	@Column(name = "ETUD_NI")
	private int niveau;
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getFiliere() {
		return filiere;
	}
	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}
	public String getFaculte() {
		return faculte;
	}
	public void setFaculte(String faculte) {
		this.faculte = faculte;
	}
	public int getNiveau() {
		return niveau;
	}
	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}
	public Etudiant(String nom, String matricule, String filiere, String faculte, int niveau) {
		
		this.nom = nom;
		this.matricule = matricule;
		this.filiere = filiere;
		this.faculte = faculte;
		this.niveau = niveau;
	}
	public Etudiant(int id, String nom, String matricule, String filiere, String faculte, int niveau) {
		
		this.id = id;
		this.nom = nom;
		this.matricule = matricule;
		this.filiere = filiere;
		this.faculte = faculte;
		this.niveau = niveau;
	}
	public Etudiant() {
		super();
	}

}
