package com.midix.dvLottery.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Child {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String postnom;
	private String prenom;
	private String lieuNais;
	private String dateNais;
	private String sexe;
	private String picture;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Customer customer;
	
	public Child() {
		super();
	}
	
	public Child(String nom, String postnom, String prenom, String lieuNais, String dateNais, String sexe,
			String picture) {
		super();
		this.nom = nom;
		this.postnom = postnom;
		this.prenom = prenom;
		this.lieuNais = lieuNais;
		this.dateNais = dateNais;
		this.sexe = sexe;
		this.picture = picture;
	}

	public Child(Long id, String nom, String postnom, String prenom, String lieuNais, String dateNais, String sexe,
			String picture, Customer customer) {
		super();
		this.id = id;
		this.nom = nom;
		this.postnom = postnom;
		this.prenom = prenom;
		this.lieuNais = lieuNais;
		this.dateNais = dateNais;
		this.sexe = sexe;
		this.picture = picture;
		this.customer = customer;
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

	public String getLieuNais() {
		return lieuNais;
	}

	public void setLieuNais(String lieuNais) {
		this.lieuNais = lieuNais;
	}

	public String getDateNais() {
		return dateNais;
	}

	public void setDateNais(String dateNais) {
		this.dateNais = dateNais;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer children) {
		this.customer = children;
	}

	@Override
	public String toString() {
		return "Child [id=" + id + ", nom=" + nom + ", postnom=" + postnom + ", prenom=" + prenom + ", lieuNais="
				+ lieuNais + ", dateNais=" + dateNais + ", sexe=" + sexe + ", picture=" + picture + ", children="
				+ customer + "]";
	}

	


}
