package com.midix.dvLottery.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Conjoint {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String postnom;
	private String prenom;
	private String nationalite;
	private String sexe;
	private Date dateNais;
	private String professison;
	private String niveauEtude;
	private String picture;
	
	@OneToOne
	private Customer customer;
	
	public Conjoint() {
		super();
	}
	
	public Conjoint(String nom, String postnom, String prenom, String nationalite, String sexe, Date dateNais,
			String professison, String niveauEtude, String picture) {
		super();
		this.nom = nom;
		this.postnom = postnom;
		this.prenom = prenom;
		this.nationalite = nationalite;
		this.sexe = sexe;
		this.dateNais = dateNais;
		this.professison = professison;
		this.niveauEtude = niveauEtude;
		this.picture = picture;
	}

	public Conjoint(Long id, String nom, String postnom, String prenom, String nationalite, String sexe, Date dateNais,
			String professison, String niveauEtude, String picture, Customer conjoint) {
		super();
		this.id = id;
		this.nom = nom;
		this.postnom = postnom;
		this.prenom = prenom;
		this.nationalite = nationalite;
		this.sexe = sexe;
		this.dateNais = dateNais;
		this.professison = professison;
		this.niveauEtude = niveauEtude;
		this.picture = picture;
		this.customer = conjoint;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPostnom() {
		return postnom;
	}

	public void setPostnom(String postnom) {
		this.postnom = postnom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public Date getDateNais() {
		return dateNais;
	}

	public void setDateNais(Date dateNais) {
		this.dateNais = dateNais;
	}

	public String getProfessison() {
		return professison;
	}

	public void setProfessison(String professison) {
		this.professison = professison;
	}

	public String getNiveauEtude() {
		return niveauEtude;
	}

	public void setNiveauEtude(String niveauEtude) {
		this.niveauEtude = niveauEtude;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Customer getConjoint() {
		return customer;
	}

	public void setConjoint(Customer conjoint) {
		this.customer = conjoint;
	}

	@Override
	public String toString() {
		return "Conjoint [id=" + id + ", nom=" + nom + ", postnom=" + postnom + ", prenom=" + prenom + ", nationalite="
				+ nationalite + ", sexe=" + sexe + ", dateNais=" + dateNais + ", professison=" + professison
				+ ", niveauEtude=" + niveauEtude + ", picture=" + picture + ", conjoint=" + customer + "]";
	}

	
	
}
