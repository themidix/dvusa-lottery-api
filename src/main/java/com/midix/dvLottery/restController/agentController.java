package com.midix.dvLottery.restController;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.midix.dvLottery.entity.Agent;
import com.midix.dvLottery.services.impl.AgentServiceImp;

@RestController
@RequestMapping("/agent")
@CrossOrigin("*")
public class agentController {

	private AgentServiceImp agentService;
	public agentController(AgentServiceImp agentService) {
		this.agentService = agentService;
	}
	@RequestMapping(method =  RequestMethod.GET)
	@PreAuthorize("hasAuthority('Admin')")
	public List<Agent> getAllAgent(){
		return agentService.getAllAgents();
	}
	
	@RequestMapping(value="/{id}",method =  RequestMethod.GET)
	@PreAuthorize("hasAuthority('Agent')")
	public Agent getAgentById(@PathVariable("id") Long id){
		return agentService.getAgent(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@PreAuthorize("hasAuthority('Admin')")
	public Agent createAgent(@RequestBody Agent agent) {
		return agentService.saveAgent(agent);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	@PreAuthorize("hasAuthority('Agent')")
	public Agent updateAgent(@RequestBody Agent agent) {
		return agentService.updateAgent(agent);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	@PreAuthorize("hasAuthority('Admin')")
	public void deleteAgent(@PathVariable("id") Long id) {
		agentService.deleteAgentById(id);
	}
}
