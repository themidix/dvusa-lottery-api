package com.midix.dvLottery.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Passport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String postnom;
	private String prenom;
	private String pays;
	private Date dateDel;
	private Date dateEx;
	private int numero;
	private String Exemptation;
	private String typeExemptation;
	
	@OneToOne
	private Customer customer;
	
	public Passport() {
		super();
	}
	
	public Passport(String nom, String postnom, String prenom, String pays, Date dateDel, Date dateEx, int numero,
			String exemptation, String typeExemptation) {
		super();
		this.nom = nom;
		this.postnom = postnom;
		this.prenom = prenom;
		this.pays = pays;
		this.dateDel = dateDel;
		this.dateEx = dateEx;
		this.numero = numero;
		Exemptation = exemptation;
		this.typeExemptation = typeExemptation;
	}

	public Passport(Long id, String nom, String postnom, String prenom, String pays, Date dateDel, Date dateEx,
			int numero, String exemptation, String typeExemptation, Customer myPassport) {
		super();
		this.id = id;
		this.nom = nom;
		this.postnom = postnom;
		this.prenom = prenom;
		this.pays = pays;
		this.dateDel = dateDel;
		this.dateEx = dateEx;
		this.numero = numero;
		Exemptation = exemptation;
		this.typeExemptation = typeExemptation;
		this.customer = myPassport;
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

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public Date getDateDel() {
		return dateDel;
	}

	public void setDateDel(Date dateDel) {
		this.dateDel = dateDel;
	}

	public Date getDateEx() {
		return dateEx;
	}

	public void setDateEx(Date dateEx) {
		this.dateEx = dateEx;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getExemptation() {
		return Exemptation;
	}

	public void setExemptation(String exemptation) {
		Exemptation = exemptation;
	}

	public String getTypeExemptation() {
		return typeExemptation;
	}

	public void setTypeExemptation(String typeExemptation) {
		this.typeExemptation = typeExemptation;
	}

	public Customer getMyPassport() {
		return customer;
	}

	public void setMyPassport(Customer myPassport) {
		this.customer = myPassport;
	}

	@Override
	public String toString() {
		return "Passport [id=" + id + ", nom=" + nom + ", postnom=" + postnom + ", prenom=" + prenom + ", pays=" + pays
				+ ", dateDel=" + dateDel + ", dateEx=" + dateEx + ", numero=" + numero + ", Exemptation=" + Exemptation
				+ ", typeExemptation=" + typeExemptation + ", myPassport=" + customer + "]";
	}

	
	
}
