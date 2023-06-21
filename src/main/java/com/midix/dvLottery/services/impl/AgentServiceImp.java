package com.midix.dvLottery.services.impl;

import java.util.List;

import com.midix.dvLottery.services.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.midix.dvLottery.models.Agent;
import com.midix.dvLottery.repository.AgentRepository;

@Service
public class AgentServiceImp implements AgentService {
	
	@Autowired
	AgentRepository agentRepository;

	@Override
	public Agent saveAgent(Agent a) {
		return agentRepository.save(a);
	}

	@Override
	public Agent updateAgent(Agent a) {
		return agentRepository.save(a);
	}

	@Override
	public void deleteAgent(Agent a) {
		agentRepository.delete(a);
	}

	@Override
	public void deleteAgentById(Long id) {
		agentRepository.deleteById(id);
	}

	@Override
	public Agent getAgent(Long id) {
		return agentRepository.findById(id).get();
	}

	@Override
	public List<Agent> getAllAgents() {
		return agentRepository.findAll();
	}
}
