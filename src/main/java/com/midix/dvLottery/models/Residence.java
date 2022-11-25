package com.midix.dvLottery.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Residence {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String commune;
	private String quartier;
	private String avenue;
	private int numero;
	private String ville;
	private String pays;

	@OneToOne
	private Customer customer;

	public Residence() {
		super();
	}

	public Residence(String commune, String quartier, String avenue, int numero, String ville, String pays) {
		super();
		this.commune = commune;
		this.quartier = quartier;
		this.avenue = avenue;
		this.numero = numero;
		this.ville = ville;
		this.pays = pays;
	}

	public Residence(Long id, String commune, String quartier, String avenue, int numero, String ville, String pays,
			Customer customer) {
		super();
		this.id = id;
		this.commune = commune;
		this.quartier = quartier;
		this.avenue = avenue;
		this.numero = numero;
		this.ville = ville;
		this.pays = pays;
		this.customer = customer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCommune() {
		return commune;
	}

	public void setCommune(String commune) {
		this.commune = commune;
	}

	public String getQuartier() {
		return quartier;
	}

	public void setQuartier(String quartier) {
		this.quartier = quartier;
	}

	public String getAvenue() {
		return avenue;
	}

	public void setAvenue(String avenue) {
		this.avenue = avenue;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Residence [id=" + id + ", commme=" + commune + ", quartier=" + quartier + ", avenue=" + avenue
				+ ", numere=" + numero + ", ville=" + ville + ", pays=" + pays + ", customer=" + customer + "]";
	}

}
