package com.midix.dvLottery.services.impl;

import java.util.List;

import com.midix.dvLottery.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.midix.dvLottery.models.Customer;
import com.midix.dvLottery.repository.CustomerRepository;

@Service
public class CustomerServiceImp implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public Customer saveCustomer(Customer c) {
		return customerRepository.save(c);
	}

	@Override
	public Customer updateCustomer(Customer c) {
		return customerRepository.save(c);
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
