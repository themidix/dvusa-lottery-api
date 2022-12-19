package com.midix.dvLottery.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.midix.dvLottery.models.Agent;
import com.midix.dvLottery.services.AgentServiceImp;

@RestController
@RequestMapping("/agent")
@CrossOrigin(origins = "http://localhost:4200")
public class agentController {

	@Autowired
	private AgentServiceImp agentService;
	
	@RequestMapping(method =  RequestMethod.GET)
	public List<Agent> getAllAgent(){
		return agentService.getAllAgents();
	}
	
	@RequestMapping(value="/{id}",method =  RequestMethod.GET)
	public Agent getAgentById(@PathVariable("id") Long id){
		return agentService.getAgent(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Agent createAgent(@RequestBody Agent agent) {
		return agentService.saveAgent(agent);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Agent updateAgent(@RequestBody Agent agent) {
		return agentService.updateAgent(agent);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteAgent(@PathVariable("id") Long id) {
		agentService.deleteAgentById(id);
	}
}
