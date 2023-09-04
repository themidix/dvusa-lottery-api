//package com.midix.dvLottery.restController;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.midix.dvLottery.models.Customer;
//import com.midix.dvLottery.services.impl.CustomerServiceImp;
//
//@RestController
//@RequestMapping("/customer")
//@CrossOrigin(origins = "*")
//public class customerController {
//	@Autowired
//	CustomerServiceImp customerService;
//
//	@RequestMapping(method =  RequestMethod.GET)
//	@PreAuthorize("hasAuthority('Admin')")
//	public List<Customer> getAllCustomer(){
//		return customerService.getAllCustomers();
//	}
//
//	@RequestMapping(value="/{id}",method =  RequestMethod.GET)
//	@PreAuthorize("hasAuthority('Customer')")
//	public Customer getCustomersById(@PathVariable("id") Long id){
//		return customerService.getCustomer(id);
//	}
//
//	@RequestMapping(method = RequestMethod.POST)
//	@PreAuthorize("hasAnyAuthority('Admin','Agent')")
//	public Customer createCustomer(@RequestBody Customer customer) {
//		return customerService.saveCustomer(customer);
//	}
//
//	@RequestMapping(method = RequestMethod.PUT)
//	@PreAuthorize("hasAuthority('Customer')")
//	public Customer updateCustomer(@RequestBody Customer customer) {
//		return customerService.updateCustomer(customer);
//	}
//
//	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
//	@PreAuthorize("hasAuthority('Admin')")
//	public void deleteCustomer(@PathVariable("id") Long id) {
//		customerService.deleteCustomerById(id);
//	}
//}
