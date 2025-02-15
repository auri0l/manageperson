package com.course.manageperson.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "ENSEIGNANT")
public class Enseignant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ENS_ID")
	private int idi;
	
	@Column(name="ENS_MAT")
	private String matricule;
	
	@Column(name="ENS_NOM")
	private String nom;
	
	@Column(name="ENS_AGE")
	private int age;
	
	public Enseignant() {
		
	}
	public Enseignant(int idi, String matricule, String nom, int age, String grade) {
		
		this.idi = idi;
		this.matricule = matricule;
		this.nom = nom;
		this.age = age;
		this.grade = grade;
	}
	public int getIdi() {
		return idi;
	}
	public void setIdi(int idi) {
		this.idi = idi;
	}
	
	public Enseignant(String matricule, String nom, int age, String grade) {
		
		this.matricule = matricule;
		this.nom = nom;
		this.age = age;
		this.grade = grade;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	private String grade;

}
