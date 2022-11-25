package com.midix.dvLottery.services;

import java.util.List;

import com.midix.dvLottery.models.Customer;

public interface CustomerService {
	Customer saveCustomer(Customer c);
	Customer updateCustomer(Customer c);
	void deleteCustomer(Customer c);
	void deleteCustomerById(Long id);
	Customer getCustomer(Long id);
	List<Customer> getAllCustomers();
}
