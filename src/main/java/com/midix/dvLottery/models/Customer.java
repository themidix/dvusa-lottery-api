package com.midix.dvLottery.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String postnom;
	private String prenom;
	private String villeNais;
	private Date dateNais;
	private String sexe;
	private String profession;
	private String niveauEtude;
	private String paysAd;
	private String etatCivil;
	private int nbrEnfant;
	private String email;
	private String tel;
	private String picture;
	private String agent;

	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE },optional = false, orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "residence")
	private Residence residence;

	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, optional = false, orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "passport")
	private Passport passport;

	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, optional = false, orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "conjoint")
	private Conjoint conjoint;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Child> children;

	public Customer() {
		super();
	}

	public Customer(String nom, String postnom, String prenom, String villeNais, Date dateNais, String sexe,
			String profession, String niveauEtude, String paysAd, String etatCivil, int nbrEnfant, String email,
			String tel, String picture, Residence residence, Passport passport, Conjoint conjoint, List<Child> children,
			String agent) {
		super();
		this.nom = nom;
		this.postnom = postnom;
		this.prenom = prenom;
		this.villeNais = villeNais;
		this.dateNais = dateNais;
		this.sexe = sexe;
		this.profession = profession;
		this.niveauEtude = niveauEtude;
		this.paysAd = paysAd;
		this.etatCivil = etatCivil;
		this.nbrEnfant = nbrEnfant;
		this.email = email;
		this.tel = tel;
		this.picture = picture;
		this.residence = residence;
		this.passport = passport;
		this.conjoint = conjoint;
		this.children = children;
		this.agent = agent;
	}

	public Customer(Long idCustomer, String nom, String postnom, String prenom, String villeNais, Date dateNais,
			String sexe, String profession, String niveauEtude, String paysAd, String etatCivil, int nbrEnfant,
			String email, String tel, String picture, Residence residence, Passport passport, Conjoint conjoint,
			List<Child> children, String agent) {
		super();
		this.id = idCustomer;
		this.nom = nom;
		this.postnom = postnom;
		this.prenom = prenom;
		this.villeNais = villeNais;
		this.dateNais = dateNais;
		this.sexe = sexe;
		this.profession = profession;
		this.niveauEtude = niveauEtude;
		this.paysAd = paysAd;
		this.etatCivil = etatCivil;
		this.nbrEnfant = nbrEnfant;
		this.email = email;
		this.tel = tel;
		this.picture = picture;
		this.residence = residence;
		this.passport = passport;
		this.conjoint = conjoint;
		this.children = children;
		this.agent = agent;
	}

	public Long getIdCustomer() {
		return id;
	}

	public void setIdCustomer(Long idCustomer) {
		this.id = idCustomer;
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

	public String getVilleNais() {
		return villeNais;
	}

	public void setVilleNais(String villeNais) {
		this.villeNais = villeNais;
	}

	public Date getDateNais() {
		return dateNais;
	}

	public void setDateNais(Date dateNais) {
		this.dateNais = dateNais;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getNiveauEtude() {
		return niveauEtude;
	}

	public void setNiveauEtude(String niveauEtude) {
		this.niveauEtude = niveauEtude;
	}

	public String getPaysAd() {
		return paysAd;
	}

	public void setPaysAd(String paysAd) {
		this.paysAd = paysAd;
	}

	public String getEtatCivil() {
		return etatCivil;
	}

	public void setEtatCivil(String etatCivil) {
		this.etatCivil = etatCivil;
	}

	public int getNbrEnfant() {
		return nbrEnfant;
	}

	public void setNbrEnfant(int nbrEnfant) {
		this.nbrEnfant = nbrEnfant;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Residence getResidence() {
		return residence;
	}

	public void setResidence(Residence residence) {
		this.residence = residence;
	}

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	public Conjoint getConjoint() {
		return conjoint;
	}

	public void setConjoint(Conjoint conjoint) {
		this.conjoint = conjoint;
	}

	public List<Child> getChildren() {
		return children;
	}

	public void setChildren(List<Child> children) {
		this.children = children;
	}
	
	public void addChildren(Child child) {
		children.add(child);
		child.setCustomer(this);
	}

	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

	@Override
	public String toString() {
		return "Customer [idCustomer=" + id + ", nom=" + nom + ", postnom=" + postnom + ", prenom=" + prenom
				+ ", villeNais=" + villeNais + ", dateNais=" + dateNais + ", sexe=" + sexe + ", profession="
				+ profession + ", niveauEtude=" + niveauEtude + ", paysAd=" + paysAd + ", etatCivil=" + etatCivil
				+ ", nbrEnfant=" + nbrEnfant + ", email=" + email + ", tel=" + tel + ", picture=" + picture
				+ ", residence=" + residence + ", passport=" + passport + ", conjoint=" + conjoint + ", children="
				+ children + ", agent=" + agent + "]";
	}

}
