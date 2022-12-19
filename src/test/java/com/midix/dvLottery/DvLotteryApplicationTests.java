//package com.midix.dvLottery;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.midix.dvLottery.models.Agent;
//import com.midix.dvLottery.models.Child;
//import com.midix.dvLottery.models.Conjoint;
//import com.midix.dvLottery.models.Customer;
//import com.midix.dvLottery.models.Passport;
//import com.midix.dvLottery.models.Residence;
//import com.midix.dvLottery.repository.AgentRepository;
//import com.midix.dvLottery.repository.ChildRepository;
//import com.midix.dvLottery.repository.ConjointRepository;
//import com.midix.dvLottery.repository.CustomerRepository;
//import com.midix.dvLottery.repository.PassportRepository;
//import com.midix.dvLottery.repository.ResidenceRepository;
//import com.midix.dvLottery.services.AgentServiceImp;
//import com.midix.dvLottery.services.ChildServiceImp;
//import com.midix.dvLottery.services.ConjointServiceImp;
//import com.midix.dvLottery.services.CustomerService;
//import com.midix.dvLottery.services.CustomerServiceImp;
//import com.midix.dvLottery.services.PassportServiceImp;
//import com.midix.dvLottery.services.ResidenceService;
//import com.midix.dvLottery.services.ResidenceServiceImp;
//
//
//@SpringBootTest
//class DvLotteryApplicationTests {
//
////	@Autowired
////	CustomerServiceImp customerService;
////
////	@Autowired
////	ConjointServiceImp conjointService;
////
////	@Autowired
////	PassportServiceImp passportService;
////
////	@Autowired
////	ResidenceServiceImp residenceService;
////
////	@Autowired
////	AgentServiceImp agentService;
////
////	@Autowired
////	ChildServiceImp childService;
////
////	@Test
////	public void testCreate() {
////
////		Conjoint conjoint = new Conjoint("pululu", "ntoya", "randy", "congolaise", "homme", new Date(), "ingenieur", "master", "");
////		Passport passport =  new Passport("dupond", "montelimard", "berangère", "france", new Date(), new Date(), 1500, "non", "aucun");
////		Residence residence = new Residence("masina", "sans-fil", "kingabwa", 15, "kinshasa", "rdc");
////		Agent agent = new Agent("musau", "musau@gmail.com", "0852645632", "homme", "kinshasa", new Date(), "administrator", "autre", 1);
////
////		Child child1 = new Child("nom", "postnom", "prenom", "kinshasa", "date", "homme", "");
////		Child child2 = new Child("nom2", "postnom2", "prenom2", "kinshasa2", "date2", "femme", "");
////
////		List<Child> listChild =  new ArrayList<Child>();
////		listChild.add(child1);
////		listChild.add(child2);
//
//		//passportService.savePassport(passport);
//		//residenceService.saveResidence(residence);
//		//agentService.saveAgent(agent);
//
//		//for (Child child : listChild) {
//		//	childService.saveChild(child);
//		//}
//
////		Customer customer = new Customer("dupond", "montelimard", "berangère", "paris", new Date(), "femme", "hotesse", "master", "france", "marier", 2, "dupondmontelimard@gmail.com", "0824565231", "", null, null, null, null, null);
////
////
////		customer.addChildren(child1);
////		customer.addChildren(child2);
////
////		customerService.updateCustomer(customer);
////
////
////	}
//
//}
