package com.midix.dvLottery.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.midix.dvLottery.models.Customer;
import com.midix.dvLottery.repository.CustomerRepository;

@Service
public class CustomerServiceImp implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Customer saveCustomer(Customer c) {
		return customerRepository.save(c);
	}

	@Override
	public Customer updateCustomer(Customer c) {
		customerRepository.findById(c.getIdCustomer()).map(
				exiting -> {
					exiting.setNom(c.getNom());
					exiting.setPostnom(c.getPostnom());
					exiting.setPrenom(c.getPrenom());
					exiting.setAgent(c.getAgent());
					exiting.setChildren(c.getChildren());
					exiting.setConjoint(c.getConjoint());
					exiting.setDateNais(c.getDateNais());
					exiting.setVilleNais(c.getVilleNais());
					exiting.setSexe(c.getSexe());
					exiting.setEmail(c.getEmail());
					exiting.setEtatCivil(c.getEtatCivil());
					exiting.setNbrEnfant(c.getNbrEnfant());
					exiting.setPassport(c.getPassport());
					exiting.setPicture(c.getPicture());
					exiting.setPaysAd(c.getPaysAd());
					exiting.setProfession(c.getProfession());
					exiting.setNiveauEtude(c.getNiveauEtude());
					exiting.setResidence(c.getResidence());
					exiting.setTel(c.getTel());
					return customerRepository.save(exiting);
				}
		).orElseThrow(null);
		return c;
	}

	@Override
	public void deleteCustomer(Customer c) {
		customerRepository.delete(c);
	}

	@Override
	public void deleteCustomerById(Long id) {
		customerRepository.deleteById(id);
	}

	@Override
	public Customer getCustomer(Long id) {
		return customerRepository.findById(id).get();
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

}
