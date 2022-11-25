package com.midix.dvLottery.models;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Agent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String email;
	private String telephone;
	private String sexe;
	private String ville;
	private Date dateEmb;
	private String fonction;
	private String password;
	private int nbrCustomer;
	
	
	public Agent() {
		super();
	}

	
	public Agent(String nom, String email, String telephone, String sexe, String ville, Date dateEmb, String fonction,
			String password, int nbrCustomer) {
		super();
		this.nom = nom;
		this.email = email;
		this.telephone = telephone;
		this.sexe = sexe;
		this.ville = ville;
		this.dateEmb = dateEmb;
		this.fonction = fonction;
		this.password = password;
		this.nbrCustomer = nbrCustomer;
	}


	public Agent(Long id, String nom, String email, String telephone, String sexe, String ville, Date dateEmb,
			String fonction, String password, int nbrCustomer) {
		super();
		this.id = id;
		this.nom = nom;
		this.email = email;
		this.telephone = telephone;
		this.sexe = sexe;
		this.ville = ville;
		this.dateEmb = dateEmb;
		this.fonction = fonction;
		this.password = password;
		this.nbrCustomer = nbrCustomer;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public String getSexe() {
		return sexe;
	}


	public void setSexe(String sexe) {
		this.sexe = sexe;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}


	public Date getDateEmb() {
		return dateEmb;
	}


	public void setDateEmb(Date dateEmb) {
		this.dateEmb = dateEmb;
	}


	public String getFonction() {
		return fonction;
	}


	public void setFonction(String fonction) {
		this.fonction = fonction;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getNbrCustomer() {
		return nbrCustomer;
	}


	public void setNbrCustomer(int nbrCustomer) {
		this.nbrCustomer = nbrCustomer;
	}


	@Override
	public String toString() {
		return "Agent [id=" + id + ", nom=" + nom + ", email=" + email + ", telephone=" + telephone + ", sexe=" + sexe
				+ ", ville=" + ville + ", dateEmb=" + dateEmb + ", fonction=" + fonction + ", password=" + password
				+ ", nbrCustomer=" + nbrCustomer + "]";
	}
	
	
	
}
